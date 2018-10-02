package com.example.aaron.budgeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button)findViewById(R.id.btnLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startMainActivity();
            }
        });


    }

    public void startMainActivity() {
        Intent intent = (new Intent(this,MainActivity.class));
        startActivity(intent);
    }







}
