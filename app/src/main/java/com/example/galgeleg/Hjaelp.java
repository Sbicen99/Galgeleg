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
        setContentView(R.layout.hjaelp);

        textV = findViewById(R.id.textV);
        textV.setText("Regler:" +
                "\n- Du skal kun skrive ét bogstav" +
                "\n- Du må ikke benytte CAPS LOCK" + "\n- Når du ser hele figuren og hører lyden, er spillet færdigt " + "\n- Du må ikke benytte tal" +
                "\n\n\nHints: der er 9 ord i galgespillet, som har at gøre med: " +
                "\n\n- Computer Science" + "\n- Transportmidler/transport" + "\n- Dyr" + "\n- Tal" + "\n\n\nMotivation/næste levels:" +
                "\n- Du kan komme til et nyt level");


        tilbageKnap = findViewById(R.id.tilbageKnap);

        tilbageKnap.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, Hovedmenu.class);
        startActivity(i);
        finish();

    }


}
