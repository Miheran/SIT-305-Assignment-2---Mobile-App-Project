package com.example.doggycaregameappjava;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RunFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //AnimationDrawable dogRun;
        //ImageView imageView = (ImageView) getView().findViewById(R.id.dogrun);
        //imageView.setBackgroundResource(R.drawable.runanimation);
        //dogRun = (AnimationDrawable) imageView.getBackground();
        return inflater.inflate(R.layout.fragment_run, container, false);
    }
}
