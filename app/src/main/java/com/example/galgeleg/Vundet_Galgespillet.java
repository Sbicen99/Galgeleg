package com.example.galgeleg;

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

public class Vundet_Galgespillet extends AppCompatActivity implements View.OnClickListener {

    Galge_spillogik logik = new Galge_spillogik();
    TextView TV1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vundet__galgespillet);


        TV1 = findViewById(R.id.TV1);
        button2 = findViewById(R.id.button2);


        button2.setOnClickListener(this);


        // Indhenter data fra 'Galge_spillet'-klassen
        Intent intent = getIntent();
        final int antalForsøg = intent.getIntExtra("antal forsøg", logik.getAntalForkerteBogstaver());



        TV1.setText("TILLYKKE!!" +
                "\nDu er klar til at prøve nye kræfter af!" + "\nTryk på globussen, og oplev verden." +
                "\n- Husk billetten og passet, for flyet letter snart!"
                + "\n\n- Du brugte " + antalForsøg + " forsøg, inden du gættede ordet!");


        MediaPlayer mp = MediaPlayer.create(this,R.raw.vundet);
        mp.start();

    }

    @Override
    public void onClick(View view) {

        // Viser en dialogboks
        AlertDialog.Builder builder = new AlertDialog.Builder(Vundet_Galgespillet.this);
        builder.setMessage("Ønsker du at rejse og prøve et nyt level?")
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


        openActivity_hawaii();

    }



    private void openActivity_hawaii() {

        // Får globussen til at rotere.
    button2.animate().rotation(button2.getRotation()-360*4).start();

    }



    private void openActivity2() {

        Intent in = new Intent(this, Galge_spillet.class);
        startActivity(in);

    }

    private void openActivity() {

        Intent intent = new Intent(this, EnTurTilHawaii.class);
        startActivity(intent);

    }
}
