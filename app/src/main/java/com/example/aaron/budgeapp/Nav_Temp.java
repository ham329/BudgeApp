package com.example.aaron.budgeapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Notification;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

public class Nav_Temp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav__temp);


        ImageButton home = (ImageButton) findViewById(R.id.home);
        //ImageButton notif = (ImageButton) findViewById(R.id.notif);
        //ImageButton rec = (ImageButton) findViewById(R.id.rec);
        //ImageButton stats = (ImageButton) findViewById(R.id.stats);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });


    }
    public void openHome(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
}
