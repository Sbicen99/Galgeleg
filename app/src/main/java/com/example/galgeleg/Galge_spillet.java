package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class Galge_spillet extends AppCompatActivity implements View.OnClickListener {

    Galge_spillogik logik = new Galge_spillogik();
    Button prøvKnap; Button prøvigenKnap; Button hjælpKnap;
    TextView TV;
    EditText ET;
    ImageView image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galge_spillet);

        logik.logStatus();
        prøvKnap = findViewById(R.id.prøvKnap);
        prøvigenKnap = findViewById(R.id.prøvigenKnap);

        ET = findViewById(R.id.ET);
        TV = findViewById(R.id.TV);
        image = findViewById(R.id.image);




        TV.setText("Velkommen til galgespillet. " +
                "\nKan du gætte dette ord: " + logik.getSynligtOrd() + "?" + "\nHusk at kæmp videre, selvom scoren ikke bliver godkendt" +
                "\nHvis du har nogle bogstaver, så fyr dem løs!");


        prøvKnap.setOnClickListener(this);


        prøvigenKnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });
    }


    @Override
    public void onClick(View view) {

        String bogstav = ET.getText().toString();

        if (bogstav.length() != 1) {
            ET.setError("Skriv præcis ét bogstav!");
            return;
        }
        logik.gætBogstav(bogstav);
        ET.setText("");
        ET.setError(null);

        // opdaterer skærmen
        updateScreen();

        // skjuler tastaturet
        prøvKnap.onEditorAction(EditorInfo.IME_ACTION_DONE);

    }



    private void updateScreen() {

        TV.setText("Ordet er: " + logik.getSynligtOrd());
        TV.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());


        if (logik.erSpilletVundet()) {

            Intent intent = new Intent(this, Vundet_Galgespillet.class);
            startActivity(intent);


        }

        if (logik.erSpilletTabt()) {

            TV.setText("DU HAR TABT! - prøv igen" + "\nOrdet var: " + logik.getOrdet()
                    + "\nDu kan prøve igen, tryk på 'Prøv igen'");
            image.setImageResource(R.drawable.sadsmiley);




        } else if (logik.getAntalForkerteBogstaver() == 1) {

            image.setImageResource(R.drawable.forkert1);


        } else if (logik.getAntalForkerteBogstaver() == 2) {

            image.setImageResource(R.drawable.forkert2);


        } else if (logik.getAntalForkerteBogstaver() == 3) {

            image.setImageResource(R.drawable.forkert3);



        } else if (logik.getAntalForkerteBogstaver() == 4) {

            image.setImageResource(R.drawable.forkert4);



        } else if (logik.getAntalForkerteBogstaver() == 5) {

            image.setImageResource(R.drawable.forkert5);



        } else if (logik.getAntalForkerteBogstaver() == 6) {

            image.setImageResource(R.drawable.forkert6);


        }
    }
}










