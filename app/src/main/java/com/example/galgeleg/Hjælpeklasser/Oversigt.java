package com.example.galgeleg.Hjælpeklasser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.galgeleg.Multiplayer.SpilMedDinMakker;
import com.example.galgeleg.R;
import com.example.galgeleg.Singleplayer.Testrunde;

public class Oversigt extends AppCompatActivity implements View.OnClickListener {

    private Button startSpillet_knap, Hjælp_Knap, Highscore_knap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oversigt);

        startSpillet_knap = findViewById(R.id.singleplayer_Knap);
        startSpillet_knap.setOnClickListener(this);



        Hjælp_Knap = findViewById(R.id.Hjælp_Knap);
        Hjælp_Knap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HjælpeAktivitet();

            }
        });


        Highscore_knap = findViewById(R.id.multiplayer_Knap);
        Highscore_knap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                multiplayerAktivitet();

            }
        });


    }

    private void multiplayerAktivitet() {

    Intent intent = new Intent(this, SpilMedDinMakker.class);
    startActivity(intent);

    }


    private void HjælpeAktivitet() {

        Intent intent = new Intent(this, Hjaelp.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, Testrunde.class);
        startActivity(intent);

    }
}