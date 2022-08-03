package com.example.volumeslider;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private AudioManager audioManager;
    Button clk1,clk2;
    MediaPlayer mdx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clk1 = (Button)findViewById(R.id.UPid);
        clk2 = (Button)findViewById(R.id.DOWNid);
        mdx = MediaPlayer.create(MainActivity.this,R.raw.game);
        seekBar=findViewById(R.id.seekBar);
        audioManager=(AudioManager)
                getApplicationContext().getSystemService(AUDIO_SERVICE);
        seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
    }
    public void clkUP(View view)
    {
        audioManager.adjustVolume(AudioManager.ADJUST_RAISE,AudioManager.FLAG_PLAY_SOUND);
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Toast.makeText(this,"Volume Up", Toast.LENGTH_LONG).show();
        mdx.start();
    }

    public void clkDOWN(View view)
    {
        audioManager.adjustVolume(AudioManager.ADJUST_LOWER,AudioManager.FLAG_PLAY_SOUND);
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Toast.makeText(this,"Volume DOWN", Toast.LENGTH_SHORT).show();
        mdx.isLooping();
        mdx = MediaPlayer.create(MainActivity.this,R.raw.game);
    }
}