package com.shonen.ukr.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private VideoView myVideoView;
    private Button playVideoBtn;
    private MediaController mediaController;
    private Button btnPlayMusuc, btnPauseMusic;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideoView = findViewById(R.id.MyVideoView);
        playVideoBtn = findViewById(R.id.btnPlayVideo);
        btnPlayMusuc = findViewById(R.id.btnPlayMusic);
        btnPauseMusic = findViewById(R.id.btnPauseMusic);

        playVideoBtn.setOnClickListener(MainActivity.this);
        btnPlayMusuc.setOnClickListener(MainActivity.this);
        btnPauseMusic.setOnClickListener(MainActivity.this);

        mediaController = new MediaController(MainActivity.this);
        mediaPlayer = MediaPlayer.create(this,R.raw.audio_file);
    }

    @Override
    public void onClick(View buttonView) {

        switch (buttonView.getId()) {
            case R.id.btnPlayVideo:
                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
                myVideoView.setVideoURI(videoUri);
                myVideoView.setMediaController(mediaController);
                mediaController.setAnchorView(myVideoView);
                myVideoView.start();
                break;
            case R.id.btnPlayMusic:
                mediaPlayer.start();
                break;
            case R.id.btnPauseMusic:
                mediaPlayer.pause();
                break;
        }

    }
}
