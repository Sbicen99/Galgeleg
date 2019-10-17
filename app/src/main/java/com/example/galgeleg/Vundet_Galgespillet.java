package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Vundet_Galgespillet extends AppCompatActivity implements View.OnClickListener {

    TextView TV1;
    Button button2;
    Galge_spillogik logik = new Galge_spillogik();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vundet__galgespillet);


        TV1 = findViewById(R.id.TV1);
        button2 = findViewById(R.id.button2);


        button2.setOnClickListener(this);


        // logik.getOrdet kan ikke finde ordet fra forrige aktivitet. Se på det.

        TV1.setText("TILLYKKE!!" +
                "\nDu er klar til prøve nye kræfter af!" + "\nTryk på globussen, og oplev verden." +
                "\n- Husk billetten og passet, for flyet letter snart!"
                + "\n\nOrdet var: " + logik.getOrdet());



        MediaPlayer mp = MediaPlayer.create(this,R.raw.vundet);
        mp.start();

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, EnTurTilHawaii.class);
        startActivity(i);


    }
}
