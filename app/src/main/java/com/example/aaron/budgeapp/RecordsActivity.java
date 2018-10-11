package com.example.aaron.budgeapp;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aaron.budgeapp.Fragments.FragmentOne;
import com.example.aaron.budgeapp.Fragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class RecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);


        ImageButton home3 = (ImageButton) findViewById(R.id.home3);
        ImageButton stats3 = (ImageButton) findViewById(R.id.stats3);
        ImageButton rec3 = (ImageButton) findViewById(R.id.rec3);
        ImageButton cam3 = (ImageButton) findViewById(R.id.cam3);
        ImageButton notif3 = (ImageButton) findViewById(R.id.notif3);
        ImageButton setting3 = (ImageButton) findViewById(R.id.setting3);

        home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        stats3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStats();
            }
        });

        rec3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRec();
            }
        });

        notif3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotif();
            }
        });

        cam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTextRecognitionActivity();
            }
        });

        setting3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetting();
            }
        });

        ImageButton btnP3 = (ImageButton) findViewById(R.id.btnProfile3);
        btnP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProfileActivity();
            }
        });



    }

    public void startTextRecognitionActivity() {
        Intent intent = new Intent(this, TextRecognitionActivity.class);
        startActivity(intent);

    }

    public void startProfileActivity(){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }


    public void openHome(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void openStats(){
        Intent intent = new Intent (this, StatsActivity.class);
        startActivity(intent);
    }

    public void openRec(){
        Intent intent = new Intent (this, RecordsActivity.class);
        startActivity(intent);
    }

    public void openNotif(){
        Intent intent = new Intent (this, NotifcationActivity.class);
        startActivity(intent);
    }

    public void openSetting(){
        Intent intent = new Intent (this, SettingActivity.class);
        startActivity(intent);
    }





}
