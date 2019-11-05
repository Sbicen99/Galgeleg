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

public class Vundet_Galgespillet extends AppCompatActivity implements View.OnClickListener {

    TextView TV1;
    Button button2; Button button;
    TextView tv_score;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vundet__galgespillet);


        tv_score = findViewById(R.id.tv_score);


        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tilføjScore();

            }
        });


        TV1 = findViewById(R.id.TV1);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(this);



        // Indhenter data fra 'Galge_spillet'-klassen
        Intent intent = getIntent();
        final int antalForsøg = intent.getIntExtra("antal forsøg", 0);


        if (antalForsøg == 0){

            score += 30;

        } else if (antalForsøg == 1){

            score += 15;

        } else if (antalForsøg == 2){

            score += 10;

        } else if (antalForsøg == 3){

            score += 5;

        } else {


            score = 1;

        }


        tv_score.setText("SCORE: " + score);


        TV1.setText("TILLYKKE!!" +
                "\nDu er klar til at prøve nye kræfter af!" + "\nTryk på globussen, og oplev et nyt level"
                + "\n\n- Du brugte " + antalForsøg + " forsøg, inden du gættede ordet!");



        //Afspiller en vinderlyd, når aktiviteten begynder
        MediaPlayer mp = MediaPlayer.create(this,R.raw.vundet);
        mp.start();

    }

    private void tilføjScore() {


        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("lastscore", score);
        editor.apply();


        Intent intent = new Intent(getApplicationContext(), Highscore_spillet.class);
        startActivity(intent);
        finish();

    }


    @Override
    public void onClick(View view) {

        // Viser en dialogboks
        AlertDialog.Builder builder = new AlertDialog.Builder(Vundet_Galgespillet.this);
        builder.setMessage("Ønsker du at prøve et nyt level?")
                .setCancelable(false)
                .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                       openActivity();
                    }
                })


                .setNegativeButton("Nej", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        openActivity2();

                    }
                });

        AlertDialog alert = builder.create();
        alert.setTitle("Vigtigt!");
        alert.show();

        Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
        nbutton.setTextColor(Color.BLACK);

        Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        pbutton.setTextColor(Color.BLACK);


        openActivity1();

    }

    private void openActivity() {

        Intent intent = new Intent(this, Next_level.class);
        startActivity(intent);

    }

    private void openActivity1() {

        // Får globussen til at rotere.
    button2.animate().rotation(button2.getRotation()-360*4).start();

    }

    private void openActivity2() {

        Intent in = new Intent(this, Galge_spillet.class);
        startActivity(in);

    }
}









