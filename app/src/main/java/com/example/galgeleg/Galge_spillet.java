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
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galge_spillet);

        logik.logStatus();
        prøvKnap = findViewById(R.id.prøvKnap_hawaii);
        prøvigenKnap = findViewById(R.id.prøvigenKnap);

        ET = findViewById(R.id.ET_hawaii);
        TV = findViewById(R.id.TV);
        image = findViewById(R.id.image);



        TV.setText("Velkommen til galgespillet. " +
                "\nKan du gætte dette ord: " + logik.getSynligtOrd() + "?" +
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

            score += 10;

            Intent intent = new Intent(this, Vundet_Galgespillet.class);
            intent.putExtra("antal forsøg", logik.getAntalForkerteBogstaver());
            startActivity(intent);

            Intent in = new Intent(this, Vundet_Galgespillet.class);
            intent.putExtra("score", score);
            startActivity(in);


        }


        if (logik.erSpilletTabt()) {

            Intent i = new Intent(this, Tabt_galgespillet.class);
            i.putExtra("mit ord", logik.getOrdet());
            startActivity(i);



        } switch (logik.getAntalForkerteBogstaver()){

            case 1:
                image.setImageResource(R.drawable.forkert1);
                break;

            case 2:
                image.setImageResource(R.drawable.forkert2);
                break;

            case 3:
                image.setImageResource(R.drawable.forkert3);
                break;

            case 4:
                image.setImageResource(R.drawable.forkert4);
                break;

            case 5:
                image.setImageResource(R.drawable.forkert5);
                break;


            default:
                image.setImageResource(R.drawable.forkert6);

        }
    }
}











