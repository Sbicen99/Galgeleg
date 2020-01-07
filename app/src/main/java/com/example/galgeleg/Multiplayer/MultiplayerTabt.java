package com.example.galgeleg.Multiplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import com.example.galgeleg.Hjælpeklasser.Oversigt;
import com.example.galgeleg.R;

public class MultiplayerTabt extends AppCompatActivity {


    private Handler handler;
    private Runnable delayRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_tabt);


        handler = new Handler();
        delayRunnable = new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Oversigt.class);
                startActivity(intent);

            }
        };
        handler.postDelayed(delayRunnable, 4000);


        //Afspiller en vinderlyd, når aktiviteten begynder
        MediaPlayer mp = MediaPlayer.create(this,R.raw.losingg);
        mp.start();


    }
}
