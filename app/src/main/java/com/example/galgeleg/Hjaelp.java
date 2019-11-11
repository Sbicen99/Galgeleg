package com.example.galgeleg;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hjaelp extends AppCompatActivity implements View.OnClickListener {

    Button tilbageKnap;
    TextView textV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hjaelp);

        textV = findViewById(R.id.textV);
        textV.setText("- Du skal kun skrive ét bogstav" +
                "\n- Du må ikke benytte CAPS LOCK" + "\n- Når du ser hele figuren og hører lyden, er spillet færdigt " + "\n- Du må ikke benytte tal" +
                "\n\n\nHints: der er 9 ord i galgespillet, som har at gøre med: " +
                "\n\n- Computer Science" + "\n- Transportmidler/transport" + "\n- Dyr" + "\n- Tal" + "\n\n\nMotivation/næste levels:" +
                "\n- Du kan komme til et nyt level");


        tilbageKnap = findViewById(R.id.tilbageKnap);

        tilbageKnap.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        // Viser en dialogboks
        AlertDialog.Builder builder = new AlertDialog.Builder(Hjaelp.this);
        builder.setMessage("Er du sikker på, at du vil gå tilbage?")
                .setCancelable(false)
                .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                       positiv();
                    }
                })

                .setNegativeButton("Nej", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        negativ();

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

    private void negativ() {

        Intent intent = new Intent(this, Hjaelp.class);
        startActivity(intent);

    }

    private void positiv() {

        Intent intent = new Intent(this, Hovedmenu.class);
        startActivity(intent);
        finish();


    }
}
