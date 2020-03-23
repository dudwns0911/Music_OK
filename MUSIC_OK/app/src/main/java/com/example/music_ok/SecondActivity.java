package com.example.music_ok;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Log.d("this", "test");

        VideoView videoView = (VideoView) findViewById(R.id.video);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.room);
        MediaController myController = new MediaController(this);
        myController.setAnchorView(videoView);
        videoView.setMediaController(myController);
        videoView.start();
    }


}
