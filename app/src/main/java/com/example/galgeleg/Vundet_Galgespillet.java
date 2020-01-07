package com.example.galgeleg;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;


public class Vundet_Galgespillet extends AppCompatActivity implements View.OnClickListener {

    private TextView TV1, tv_score;
    private Button nextLevel, gemKnap;
    int score = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vundet__galgespillet);


        tv_score = findViewById(R.id.tv_score);

        gemKnap = findViewById(R.id.gemKnap);

        gemKnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               tilføjScore();

            }
        });


        TV1 = findViewById(R.id.TV1);
        nextLevel = findViewById(R.id.nextLevel);

        nextLevel.setOnClickListener(this);


        // Indhenter data fra 'Spillets_Testrunde'-klassen
        Intent intent = getIntent();
        final int antalForsøg = intent.getIntExtra("antal forsøg", 0);




        if (antalForsøg == 0){

            score -= 0;

        } else if (antalForsøg == 1){

            score -= 10;

        } else if (antalForsøg == 2){

            score -= 20;

        } else if (antalForsøg == 3){

            score -= 30;

        } else if (antalForsøg == 4) {

            score -= 40;

        } else if (antalForsøg == 5) {

            score -= 50;

        } else if (antalForsøg == 60) {

            score -=60;

        } else {

            score = 0;

        }



        tv_score.setText("SCORE: " + score);


        TV1.setText("TILLYKKE!!" +
                "\nDu er klar til at prøve igen!" + "\nTryk på pilen, og prøv!"
                + "\n\n- Du brugte " + antalForsøg + " forsøg, inden du gættede ordet!");




        //Afspiller en vinderlyd, når aktiviteten begynder
        MediaPlayer mp = MediaPlayer.create(this,R.raw.vundet);
        mp.start();


        /*
        Konfetti:
        Koden er fundet her: https://android-arsenal.com/details/1/5884

        Animationer:
        https://lottiefiles.com/677-trophy
        https://lottiefiles.com/342-success
        https://lottiefiles.com/11864-crying

        Hjælp til opsætning:
        https://www.youtube.com/watch?v=T4v72xJqNpQ

         */

        KonfettiView konfettiView = findViewById(R.id.viewKonfetti);
        konfettiView.build()
                .addColors(Color.WHITE, Color.GREEN, Color.BLACK)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5f))
                .setPosition(640f, (float) konfettiView.getWidth() + 50f, 0f, -150f)
                .stream(150, 5000L);


    }


    private void tilføjScore() {

        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("lastscore", score);
        editor.apply();

        Intent intent = new Intent(this, Highscore.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View view) {

                //Viser en dialogboks
        AlertDialog.Builder builder = new AlertDialog.Builder(Vundet_Galgespillet.this);
        builder.setMessage("Ønsker du at spille med ord hentet fra DR?")
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

    private void openActivity() {

        Intent intent = new Intent(this, Galge_spillet.class);
        startActivity(intent);
        finish();

    }

    private void openActivity1() {

        Intent intent = new Intent(this, Spillets_Testrunde.class);
        startActivity(intent);

    }
}









