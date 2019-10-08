package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        setContentView(R.layout.activity_hjaelp);

        textV = findViewById(R.id.textV);
        textV.setText("- Du skal kun skrive ét bogstav" +
                "\n\n- Du må ikke benytte CAPS LOCK" + "\n\n- Du må ikke benytte tal" +
                "\n\n\nHints: der er 9 ord i galgespillet, hvor de har at gøre med: " +
                "\n\n- Computer Science" + "\n- Transportmidler/transport" + "\n- Dyr" + "\n- Tal" +
                "\n\n\n- Higscore tæller op med 1 hver gang, du vinder ét spil" +
                "\n\n- Hvis du taber ét spil, fratrækkes ét point fra din samlede score");


        tilbageKnap = findViewById(R.id.tilbageKnap);

        tilbageKnap.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, Galge_spillet.class);
        startActivity(i);

    }
}
