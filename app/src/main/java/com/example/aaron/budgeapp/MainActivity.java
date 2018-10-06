package com.example.aaron.budgeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnOCR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOCR = findViewById(R.id.btnOCR);
        btnOCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTextRecognitionActivity();
            }
        });
    }
    public void startTextRecognitionActivity() {
        Intent intent = new Intent(MainActivity.this, TextRecognitionActivity.class);
        startActivity(intent);

    }

}
