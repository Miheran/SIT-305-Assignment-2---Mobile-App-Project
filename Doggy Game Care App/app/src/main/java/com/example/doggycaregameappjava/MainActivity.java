package com.example.doggycaregameappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.graphics.Point;
import android.media.Image;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    //How long a run goes for as listed in Milliseconds
    private static final long RUN_TIME = 6000;

    //Buttons for Home Fragment
    Button btnRunHome;
    Button btnVideoHome;
    Button btnSleep;
    //Buttons for Run Fragments
    Button btnHomeRun;
    Button btnVideoRun;
    Button btnRunStart;
    //Buttons for Video Fragments
    Button btnHomeVideo;
    Button btnRunVideo;
    Button btnPlay;
    //Chronometer for the Run time
    Chronometer chrRunTime;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btnVideoRun = findViewById(R.id.videorun);
        btnHomeVideo = findViewById(R.id.homevideo);
        btnRunVideo = findViewById(R.id.runvideo);
        btnRunStart = findViewById(R.id.runstart);

        Fragment frag;

        VideoView videoView = findViewById(R.id.openVideo);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.openvideo2;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


        //if (savedInstanceState == null) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLO,
                    //new HomeFragment()).commit();
        //}
    }

    public void onStartService(View v)
    {
        Intent serviceRun = new Intent(this, RunningService.class);
        serviceRun.putExtra("RunTime", RUN_TIME);

        startService(serviceRun);
    }

    public void homeFragment(View view)
    {
        /*FragmentManager manager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction ft = manager.beginTransaction();
        Fragment homeFrag = manager.findFragmentById(R.id.fragmentLO);
        if(homeFrag.isHidden())
        {
            ft.show(homeFrag);
            ft.commit();
        }*/
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLO, new HomeFragment()).addToBackStack(null).commit();
    }

    public void runFragment(View view)
    {
        /*FragmentManager manager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction ft = manager.beginTransaction();
        Fragment homeFrag = manager.findFragmentById(R.id.fragmentLO);
        if(homeFrag.isHidden())
        {
            ft.show(homeFrag);
            ft.commit();
        }*/
        btnRunStart.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLO, new RunFragment()).addToBackStack(null).commit();
    }

    public void videoFragment(View view)
    {
//        FragmentManager manager = getSupportFragmentManager();
//        androidx.fragment.app.FragmentTransaction ft = manager.beginTransaction();
//        Fragment homeFrag = manager.findFragmentById(R.id.fragmentLO);
//        ft.hide(homeFrag);
//        ft.commit();
    }


}
