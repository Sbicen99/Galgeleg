package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Forside extends AppCompatActivity implements View.OnClickListener {

    ImageView LogI, Highscore, Hjælp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forside);

        LogI = findViewById(R.id.spil_Knap);
        LogI.setOnClickListener(this);


        Highscore = findViewById(R.id.Highscoree_Knap);

        Highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                highscoreActivity();


            }
        });



        Hjælp = findViewById(R.id.Hjælp_Knap);

        Hjælp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hjælpeActivity();

            }
        });


    }

    private void highscoreActivity() {

        Intent intent = new Intent(this, Highscore_spillet.class);
        startActivity(intent);



    }

    private void hjælpeActivity() {

       Intent intent = new Intent(this, Hjaelp.class);
       startActivity(intent);

    }

    @Override
    public void onClick(View v) {

        Toast.makeText(Forside.this, "Starter spillet...", //Viser en besked
                Toast.LENGTH_SHORT).show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(Forside.this, Galge_spillet.class);
                startActivity(i);
            }
        }, 2000); //sætter et delay på 2 sek.


    }
}
