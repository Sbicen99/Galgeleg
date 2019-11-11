package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Forside extends AppCompatActivity implements View.OnClickListener {

    ImageView LogI;
    ImageView Highscore;
    ImageView Hjælp;

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

        Intent intent = new Intent(this, Galge_spillet.class);
        startActivity(intent);

    }
}
