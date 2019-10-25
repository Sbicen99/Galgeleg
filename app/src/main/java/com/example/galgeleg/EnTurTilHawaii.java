package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;


public class EnTurTilHawaii extends AppCompatActivity {

    TextView TV_hawaii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.en_tur_til_hawaii);


        TV_hawaii = findViewById(R.id.TV_hawaii);
        TV_hawaii.setText("HAWAII!");


        final MediaPlayer mp = MediaPlayer.create(this,R.raw.ocean_sound);
        mp.start();

        Handler handler = new Handler();
        Runnable stopPlaybackRun = new Runnable() {
            @Override
            public void run() {

                mp.stop();

            }
        };


        handler.postDelayed(stopPlaybackRun, 2000); //Afspiller lyden i 2 sekunder.

    }
}