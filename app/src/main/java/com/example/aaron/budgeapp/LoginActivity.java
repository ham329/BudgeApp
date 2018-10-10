package com.example.aaron.budgeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button button;
    private EditText Name;
    private EditText Password;
    private ProgressDialog progressDialog;
    //Used to control the wrong pw msg
    private boolean isPwWrong;


    //private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etPassword);
        //mAuth = FirebaseAuth.getInstance();



        //login button
        button = findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                validate(Name.getText().toString(), Password.getText().toString());
//                startMainActivity();
            }
        });


    }

    public void startMainActivity() {
        Intent intent = (new Intent(this,MainActivity.class));
        startActivity(intent);
    }

    private void validate(String userName, String userPassword){


        if((userName.equals("admin"))&& userPassword.equals("12345")){
            startMainActivity();
            //Password is correct keep the wrong pw msg invisible
            isPwWrong = false;
            wrongPW(isPwWrong);

        }
        else {
            //button.setEnabled(false);
            //password or username is incorrect change msg visibility to visible
            isPwWrong = true;
            wrongPW(isPwWrong);
        }

    }

    //Controls the visibility to wrong pw msg
    private void wrongPW(boolean isWrong){
        TextView textView = (TextView) findViewById(R.id.text_view_alert);
        textView.setText("Wrong username and/or password");
        if(isWrong){
            textView.setVisibility(View.VISIBLE);

        }
        else{
            textView.setVisibility(View.INVISIBLE);
        }
    }



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








}
