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

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        ImageButton home2 = (ImageButton) findViewById(R.id.home2);
        ImageButton stats2 = (ImageButton) findViewById(R.id.stats2);
        ImageButton rec2 = (ImageButton) findViewById(R.id.rec2);
        ImageButton cam2 = (ImageButton) findViewById(R.id.cam2);
        ImageButton notif2 = (ImageButton) findViewById(R.id.notif2);
        ImageButton setting2 = (ImageButton) findViewById(R.id.setting2);

        home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        stats2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStats();
            }
        });

        rec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRec();
            }
        });

        notif2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotif();
            }
        });

        cam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTextRecognitionActivity();
            }
        });

        setting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetting();
            }
        });

        ImageButton btnP2 = (ImageButton) findViewById(R.id.btnProfile2);
        btnP2.setOnClickListener(new View.OnClickListener() {
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
