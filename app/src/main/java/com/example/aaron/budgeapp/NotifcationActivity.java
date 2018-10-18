package com.example.aaron.budgeapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v7.app.ActionBar;

import com.example.aaron.budgeapp.Fragments.FragmentOne;
import com.example.aaron.budgeapp.Fragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;
public class NotifcationActivity extends AppCompatActivity {

    //private final String CHANNEL_ID = "Notification";
    //private final int notification_ID = 001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifcation);



        ImageButton home4 = (ImageButton) findViewById(R.id.home4);
        ImageButton cam4 = (ImageButton) findViewById(R.id.cam4);
        ImageButton notif4 = (ImageButton) findViewById(R.id.notif4);
        ImageButton setting4 = (ImageButton) findViewById(R.id.setting4);

        home4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });


        notif4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotif();
            }
        });

        cam4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTextRecognitionActivity();
            }
        });

        setting4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetting();
            }
        });

        ImageButton btnP4 = (ImageButton) findViewById(R.id.btnProfile4);
        btnP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProfileActivity();
            }
        });


        Button collectPrize = (Button) findViewById(R.id.collectPrize);
        collectPrize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //collect();
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

    public void openNotif(){
        Intent intent = new Intent (this, NotifcationActivity.class);
        startActivity(intent);
    }

    public void openSetting(){
        Intent intent = new Intent (this, SettingActivity.class);
        startActivity(intent);
    }



}

