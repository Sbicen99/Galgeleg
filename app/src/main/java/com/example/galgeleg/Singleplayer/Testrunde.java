package com.example.galgeleg.Singleplayer;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.galgeleg.Logik.Logik;
import com.example.galgeleg.R;
import com.example.galgeleg.SpilletsAfslutning.Tabt_galgespillet;
import com.example.galgeleg.SpilletsAfslutning.Vundet_Galgespillet;


public class Testrunde extends AppCompatActivity implements View.OnClickListener {

    Logik logik = new Logik();
    private Button prøvKnap, prøvigenKnap;
    private TextView TV;
    private EditText ET;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spillets_testrunde);

        logik.logStatus();
        prøvKnap = findViewById(R.id.prøvKnap);
        prøvigenKnap = findViewById(R.id.prøvigenKnap);

        ET = findViewById(R.id.ET);
        TV = findViewById(R.id.TV);


        image = findViewById(R.id.image);



        TV.setText("Velkommen til galgespillet! " +
                    "\nKan du gætte ordet: " +  logik.getSynligtOrd() + "?" );


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
           InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
           imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }


    private void updateScreen() {

        TV.setText("Ordet er: " + logik.getSynligtOrd());
        TV.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());


        if (logik.erSpilletVundet()) {

            Intent intent = new Intent(this, Vundet_Galgespillet.class);
            intent.putExtra("antal forsøg", logik.getAntalForkerteBogstaver());
            startActivity(intent);
            finish();

        }


        if (logik.erSpilletTabt()) {

            Intent i = new Intent(this, Tabt_galgespillet.class);
            i.putExtra("mit ord", logik.getOrdet());
            startActivity(i);
            finish();


        } switch (logik.getAntalForkerteBogstaver()){

            case 0:
                image.setImageResource(R.drawable.galge);
                break;

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











