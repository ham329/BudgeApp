package com.example.aaron.budgeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton home = (ImageButton) findViewById(R.id.home);
        ImageButton notification = (ImageButton) findViewById(R.id.notification);
        ImageButton records = (ImageButton) findViewById(R.id.records);
        ImageButton stats = (ImageButton) findViewById(R.id.stats);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotif();
            }
        });
        records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRec();
            }
        });
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStats();
            }
        });



    }

    public void openHome(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void openNotif(){
        Intent intent1 = new Intent(this, Notif.class);
        startActivity(intent1);

    }
    public void openRec(){
        Intent intent2 = new Intent (this, Records.class);
        startActivity(intent2);
    }
    public void openStats(){
        Intent intent3= new Intent(this, Stats.class);
        startActivity(intent3);
    }

}
