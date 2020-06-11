package com.example.doggycaregameappjava;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);

        VideoView view = (VideoView)rootView.findViewById(R.id.openVideo);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.openvideo2;
        view.setVideoURI(Uri.parse(path));
        view.start();
        return inflater.inflate(R.layout.fragment_video, container, false);
    }
}
/*View rootView = inflater.inflate(R.layout.fragment_video, container, false);

    VideoView video =  (VideoView)rootView.findViewById(R.id.openVideo);
    String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.openvideo2;
        video.setVideoURI(Uri.parse(videoPath));

                MediaController mc= new MediaController(getActivity().getApplicationContext());
                video.setMediaController(mc);
                mc.setAnchorView(video);
                video.start();
                video.requestFocus();*/
