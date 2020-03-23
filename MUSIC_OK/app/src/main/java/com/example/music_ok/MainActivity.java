package com.example.music_ok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = new MediaPlayer();
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mimageView = findViewById(R.id.lol);
        mimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "이미지를 클릭하셨습니다.", Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent(v.getContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer =MediaPlayer.create(this, R.raw.ground);
        mediaPlayer.setLooping(false);
        mediaPlayer.seekTo(length);
        mediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer.isPlaying()){
            length = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
            mediaPlayer.release();
    }
}

    @Override
    protected void onDestroy() {
            super.onDestroy();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            length =mediaPlayer.getCurrentPosition();
            mediaPlayer.release();
        }
    }


}
