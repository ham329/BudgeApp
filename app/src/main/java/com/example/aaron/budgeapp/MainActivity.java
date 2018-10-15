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

public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private ImageView imageView;

    //private Button btnOCR;
    private ImageButton btnP;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton home = (ImageButton) findViewById(R.id.home);
        ImageButton cam = (ImageButton) findViewById(R.id.cam);
        ImageButton notif = (ImageButton) findViewById(R.id.notif);
        ImageButton setting = (ImageButton) findViewById(R.id.setting);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });


        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotif();
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTextRecognitionActivity();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetting();
            }
        });

        btnP = findViewById(R.id.btnProfile);
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


       /*N btnOCR = findViewById(R.id.btnOCR);
        btnOCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTextRecognitionActivity();

            }
        });
        */

        btnP = findViewById(R.id.btnProfile);
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProfileActivity();
            }
        });




    }
    public void startTextRecognitionActivity() {
        Intent intent = new Intent(MainActivity.this, TextRecognitionActivity.class);
        startActivity(intent);

    }

    public void startProfileActivity(){
        Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
        startActivity(intent);
    }

    public void openHome(){
        Intent intent = new Intent (this, MainActivity.class);
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
