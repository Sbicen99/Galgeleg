package com.example.galgeleg.SpilletsAfslutning;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.galgeleg.R;
import com.example.galgeleg.Singleplayer.GalgeSpillet;
import com.example.galgeleg.Singleplayer.Testrunde;

public class Tabt_galgespillet extends AppCompatActivity implements View.OnClickListener {


    private TextView TV_tabt;
    private Button prøvigenKnap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabt_galgespillet);


        TV_tabt = findViewById(R.id.TV_tabt);

        prøvigenKnap = findViewById(R.id.prøvigenKnap);


        // Indhenter data fra 'Testrunde'-klassen
        Intent i = getIntent();
        final String mitOrd = i.getStringExtra("mit ord");



        TV_tabt.setText("DU HAR TABT! - prøv igen" + "\nOrdet var: " + mitOrd
                + "\nDu kan prøve igen, tryk på 'Prøv igen'");

        prøvigenKnap.setOnClickListener(this);

        MediaPlayer mp = MediaPlayer.create(this,R.raw.tabt);
        mp.start();


    }

    @Override
    public void onClick(View view) {

        //Viser en dialogboks
        AlertDialog.Builder builder = new AlertDialog.Builder(Tabt_galgespillet.this);
        builder.setMessage("Ønsker du at prøve testrunden igen?")
                .setCancelable(false)
                .setPositiveButton("Ja!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        openActivity();
                    }
                })

                .setNegativeButton("Nej!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        openActivity1();

                    }
                });

        AlertDialog alert = builder.create();
        alert.setTitle("Vigtigt!");
        alert.show();

        Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
        nbutton.setTextColor(Color.BLACK);

        Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        pbutton.setTextColor(Color.BLACK);

    }

    private void openActivity1() {

        Intent intent = new Intent(this, GalgeSpillet.class);
        startActivity(intent);

    }

    private void openActivity() {

        Intent intent = new Intent(this, Testrunde.class);
        startActivity(intent);

    }
}
