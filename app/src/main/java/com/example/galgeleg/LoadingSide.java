package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingSide extends AppCompatActivity {

    private Handler handler;
    private Runnable delayRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_side);

        handler = new Handler();
        delayRunnable = new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Oversigt.class);
                startActivity(intent);
            }
        };
        handler.postDelayed(delayRunnable, 2400);
    }
}
