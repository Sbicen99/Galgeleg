package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Oversigt extends AppCompatActivity implements View.OnClickListener {

    private Button startSpillet_knap, Hjælp_Knap, Highscore_knap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oversigt);

        startSpillet_knap = findViewById(R.id.startSpillet_knap);
        startSpillet_knap.setOnClickListener(this);



        Hjælp_Knap = findViewById(R.id.Hjælp_Knap);
        Hjælp_Knap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HjælpeAktivitet();

            }
        });


        Highscore_knap = findViewById(R.id.Highscore_knap);
        Highscore_knap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                highScoreAktivitet();

            }
        });


    }

    private void highScoreAktivitet() {

        Intent intent = new Intent(this, Highscore.class);
        startActivity(intent);

    }

    private void HjælpeAktivitet() {

        Intent intent = new Intent(this, Hjaelp.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, Spillets_Testrunde.class);
        startActivity(intent);

    }
}