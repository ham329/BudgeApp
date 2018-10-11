package com.example.aaron.budgeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int RC_SIGN_IN = 9001;
    public static final String TAG = "Google Activity";

    private Button button;
    private EditText Name;
    private EditText Password;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    private GoogleSignInClient googleSignIn;
    private TextView status;
    private TextView detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Views
        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etPassword);
        status = (TextView)findViewById(R.id.status);
        detail = (TextView)findViewById(R.id.detail);

        // Buttons
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnGoogleLogin).setOnClickListener(this);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                validate(Name.getText().toString(), Password.getText().toString());
//                // startMainActivity();
//            }
//        });

        // Config Google Sign in
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignIn = GoogleSignIn.getClient(this, gso);

        // init firebase auth
        mAuth = FirebaseAuth.getInstance();

    }// end onCreate()

    @Override
    public void onStart(){
        super.onStart();
        // check if the user is signed in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        // the result returned from launching intent from google sign in api
        if( requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                // the google sign in was successful, authenticate with firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e){
                // google sign in failed
                Log.w("Google Sign in Failed.", e);
            }
        }
    }// end onActivityResult()

    private void firebaseAuthWithGoogle(GoogleSignInAccount account){
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            // sign in success, update ui with signed in user's credentials
                            Log.d(TAG, "sign in with credential success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }else{
                            // sign in failed, display message to user
                            Log.w(TAG, "sign in with credential failed", task.getException());
                            updateUI(null);
                        }
                    }
                });
    }// end firebaseAuthWithGoogle()

    private void signIn(){
        Intent signInIntent = googleSignIn.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }// end signIn

    // TODO: update updateUI()
    private void updateUI(FirebaseUser user){
        // if there is a user signed in
        if (user != null) {
            // get their email and password
            status.setText(getString(R.string.google_status_fmt, user.getEmail()));
            detail.setText(getString(R.string.firebase_status_fmt, user.getUid()));
        }else{
            // sign in the user
        }
    }// end updateUI()

    public void revokeAccess(){
        // firebase sign out
        mAuth.signOut();

        // googles revoke access
        googleSignIn.revokeAccess().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                updateUI(null);
            }
        });
    } // end revokeAccess()

    @Override
    public void onClick(View v){
        int i = v.getId();
        if (i == R.id.btnLogin) {
            signIn();
        } else {
            revokeAccess();
        }
    }

    // TEST

//    public void startMainActivity() {
//        Intent intent = (new Intent(this,MainActivity.class));
//        startActivity(intent);
//    }
//
//    private void validate(String userName, String userPassword){
//
//
//        if((userName.equals("admin"))&& userPassword.equals("12345")){
//            startMainActivity();
//        }
//        else {
//            button.setEnabled(false);
//        }
//
//    }

    /*
    *
    * Firebase authentication
    *
    *
    */
/*
    private void validate(String userName, String userPassword) {

        progressDialog.setMessage("Signing in...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    checkEmailVerification();
                }else{
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    counter--;
                    Info.setText("No of attempts remaining: " + counter);
                    progressDialog.dismiss();
                    if(counter == 0){
                        Login.setEnabled(false);
                    }
                }
            }
        });


    }

    private void checkEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag = firebaseUser.isEmailVerified();

        startActivity(new Intent(MainActivity.this, SecondActivity.class));

        if(emailflag){
            finish();
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }else{
            Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }

*/








}// end loginActivity
