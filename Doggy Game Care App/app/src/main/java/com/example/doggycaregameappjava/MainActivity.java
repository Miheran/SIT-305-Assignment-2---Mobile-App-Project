package com.example.doggycaregameappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
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

    //Buttons declaration for sections of the app
    Button btnHome;
    Button btnRun;
    Button btnVideo;
    //Button for the Dog activities
    Button btnRunStart;
    Button btnSleep;
    //Chronometer for the Run time
    Chronometer chrRunTime;
    //Animation Image to use for dog
    AnimationDrawable dogAnm;
    ImageView dogImg;
    //Video View
    VideoView startVideo;


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btnVideoRun = findViewById(R.id.videorun);
        btnHome = findViewById(R.id.homebtn);
        btnRun = findViewById(R.id.runbtn);
        btnVideo = findViewById(R.id.videobtn);
        btnRunStart = findViewById(R.id.runstart);
        btnSleep = findViewById(R.id.sleep);
        chrRunTime = findViewById(R.id.runtime);
        dogImg = (ImageView) findViewById(R.id.dogImg);
        startVideo = findViewById(R.id.openVideo);

        //old function from previous version
        //Fragment frag;

        //Setting up the video so it can be played
        VideoView videoView = findViewById(R.id.openVideo);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.openvideo2;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        //Sets the dog animation to the Idle Animation
        dogImg.setBackgroundResource(R.drawable.idleanimation);
        dogAnm = (AnimationDrawable) dogImg.getBackground();

        //if (savedInstanceState == null) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLO,
                    //new HomeFragment()).commit();
        //}
    }

    //A method to set everything invisble so that only the ones needed at the time to be visiible
    public void visbility()
    {
        btnHome.setVisibility(View.INVISIBLE);
        btnRun.setVisibility(View.INVISIBLE);
        btnVideo.setVisibility(View.INVISIBLE);
        btnRunStart.setVisibility(View.INVISIBLE);
        chrRunTime.setVisibility(View.INVISIBLE);
        dogImg.setVisibility(View.INVISIBLE);
        startVideo.setVisibility(View.INVISIBLE);
    }

    //Starts a Service that alerts the owner when the dog finishes running
    public void onStartService(View v)
    {
        Intent serviceRun = new Intent(this, RunningService.class);
        serviceRun.putExtra("RunTime", RUN_TIME);

        dogImg.setBackgroundResource(R.drawable.runanimation);
        dogAnm = (AnimationDrawable) dogImg.getBackground();

        startService(serviceRun);
    }

    public void homeSection(View view)
    {
        visbility();
        //Set the required items as visible
        btnRun.setVisibility(View.VISIBLE);
        btnVideo.setVisibility(View.VISIBLE);
        btnSleep.setVisibility(View.VISIBLE);
        dogImg.setVisibility(View.VISIBLE);
    }

    public void runSection(View view)
    {
        visbility();
        //Set the required items as visible
        btnHome.setVisibility(View.VISIBLE);
        btnVideo.setVisibility(View.VISIBLE);
        chrRunTime.setVisibility(View.VISIBLE);
        btnRunStart.setVisibility(View.VISIBLE);
        dogImg.setVisibility(View.VISIBLE);
    }

    public void videoSection(View view)
    {
        visbility();
        //Set the required items as visible
        btnHome.setVisibility(View.VISIBLE);
        btnRun.setVisibility(View.VISIBLE);
        startVideo.setVisibility(View.VISIBLE);
    }

    public void sleeping(View v)
    {
        //Sets the Dog Animation to sleeping
        dogImg.setBackgroundResource(R.drawable.sleepanimation);
        dogAnm = (AnimationDrawable) dogImg.getBackground();
    }


}
