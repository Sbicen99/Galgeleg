package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tabt_galgespillet extends AppCompatActivity implements View.OnClickListener {

    TextView TV_tabt;
    Button prøvigenKnap;
    Galge_spillogik logik = new Galge_spillogik();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabt_galgespillet);


        TV_tabt = findViewById(R.id.TV_tabt);

        prøvigenKnap = findViewById(R.id.prøvigenKnap);


        //
        TV_tabt.setText("DU HAR TABT! - prøv igen" + "\nOrdet var: " + logik.getOrdet()
                + "\nDu kan prøve igen, tryk på 'Prøv igen'");

        prøvigenKnap.setOnClickListener(this);

        MediaPlayer mp = MediaPlayer.create(this,R.raw.tabt);
        mp.start();


    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, Galge_spillet.class);
        startActivity(intent);

    }
}
