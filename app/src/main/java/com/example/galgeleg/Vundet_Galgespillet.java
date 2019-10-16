package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class Vundet_Galgespillet extends AppCompatActivity {

    TextView TV1;
    Galge_spillogik logik = new Galge_spillogik();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vundet__galgespillet);


        TV1 = findViewById(R.id.TV1);

        TV1.setText("TILLYKKE!!" + "\nGODT KLARET!" + "\n\nOrdet var: " + logik.getOrdet());



        MediaPlayer mp = MediaPlayer.create(this,R.raw.vundet);
        mp.start();

    }
}
