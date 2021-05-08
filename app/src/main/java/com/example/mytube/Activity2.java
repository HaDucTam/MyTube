package com.example.mytube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Activity2 extends AppCompatActivity {
    VideoView videoView;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent = getIntent();
        String key = intent.getStringExtra("LINK");

        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath(key);
        videoView.setMediaController(new MediaController(this));
        videoView.start();
    }
    @Override
    public void onStop() {
        super.onStop();
        videoView.stopPlayback();
    }
    @Override
    public void onStart() {
        super.onStart();
        videoView.start();
    }
    @Override
    public void onPause() {
        super.onPause();
        position = videoView.getCurrentPosition();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("PLAYBACK", this.position);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        videoView.seekTo(savedInstanceState.getInt("PLAYBACK"));
    }
}