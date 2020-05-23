package com.example.application.musicalapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;

public class MusicPlayer extends AppCompatActivity implements View.OnClickListener{

    private Timer timer = new Timer();
    private TimerTask timerTask;
    private TextView name,start,end;
    private ImageView thumbnail;
    private boolean isPlaying;
    private ImageView play,ff,fb;
    private SeekBar seekBar;
    private int length;
    private DecimalFormat decimalFormat;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_player);
        decimalFormat = new DecimalFormat("00");
        name = findViewById(R.id.name);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        thumbnail = findViewById(R.id.thumbnail);
        play = findViewById(R.id.play_btn);
        ff = findViewById(R.id.ff_btn);
        fb = findViewById(R.id.fb_btn);
        seekBar = findViewById(R.id.seekBar);
        name.setText(getIntent().getStringExtra("name"));
        length = getIntent().getIntExtra("length",0);
        seekBar.setMax(length);
        seekBar.setProgress(0);
        isPlaying = true;
        play.setImageResource(R.drawable.pause_white);
        end.setText(decimalFormat.format(length/60)+":"+decimalFormat.format(length%60));
        playSeekbar();
        switch (getIntent().getIntExtra("artist_id",0)){

            case 0:
                thumbnail.setImageResource(R.drawable.believer);
                break;

            case 1:
                thumbnail.setImageResource(R.drawable.alan);
                break;

            case 2:
                thumbnail.setImageResource(R.drawable.thescore);
                break;

            case 3:
                thumbnail.setImageResource(R.drawable.unlikely);
                break;

            case 4:
                thumbnail.setImageResource(R.drawable.amau);
                break;
        }



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                start.setText(decimalFormat.format(progress/60)+":"+decimalFormat.format(progress%60));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void fastBackward(){
        if (seekBar.getProgress() > 5) {
            seekBar.setProgress(seekBar.getProgress()-5);

        }else{
            seekBar.setProgress(0);


        }

    }

    private void fastForward(){
        if (length - seekBar.getProgress() > 5) {
            seekBar.setProgress(seekBar.getProgress()+5);

        }else{
            seekBar.setProgress(length);
            pauseSeekbar();

        }
    }

    private void playBtn(){
        if (isPlaying){

            pauseSeekbar();

            //pause the seekbar

        }else{
            isPlaying = true;
            if (seekBar.getProgress() == length){
                seekBar.setProgress(0);
            }
            play.setImageResource(R.drawable.pause_white);
            playSeekbar();
            //play the seekbar

        }
    }

    private void playSeekbar() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (seekBar.getProgress() < length) {
                            seekBar.setProgress((seekBar.getProgress()+1));
                        }else {
                            pauseSeekbar();
                        }
                    }
                });

            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }

    private void pauseSeekbar() {
        isPlaying = false;
        play.setImageResource(R.drawable.play_white);
        timerTask.cancel();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.play_btn:
                playBtn();
                break;

            case R.id.ff_btn:
                fastForward();
                break;

            case R.id.fb_btn:
                fastBackward();
                break;



        }
    }
}
