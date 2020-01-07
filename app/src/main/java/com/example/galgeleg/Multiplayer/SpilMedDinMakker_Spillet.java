package com.example.galgeleg.Multiplayer;

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
import com.example.galgeleg.Multiplayer.MultiplayerTabt;
import com.example.galgeleg.Multiplayer.MultiplayerVundet;
import com.example.galgeleg.Multiplayer.OrdDatabase;
import com.example.galgeleg.R;

public class SpilMedDinMakker_Spillet extends AppCompatActivity implements View.OnClickListener {

    Logik logik = new Logik();
    OrdDatabase ordDatabase = new OrdDatabase();
    private TextView TV_spil3;
    private EditText ET_spil3;
    private ImageView IV_spil3;
    private Button prøvigenKnap_spil3, prøvKnap_spil3;
    private String skjultOrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spillet_spil_med_din_makker);


        TV_spil3 = findViewById(R.id.TV_spil3);
        ET_spil3 = findViewById(R.id.ET_spil3);
        IV_spil3 = findViewById(R.id.IV_spil3);

        prøvKnap_spil3 = findViewById(R.id.prøvKnap_spil3);
        prøvKnap_spil3.setOnClickListener(this);


        prøvigenKnap_spil3 = findViewById(R.id.prøvigenKnap_spil3);
        prøvigenKnap_spil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });

        //Skjuler ordet som bliver valgt
        skjultOrd = ordDatabase.valgtord.replaceAll(".", "*");
        TV_spil3.setText("Velkommen til multiplayer-galgespillet! " +
                "\nKan du gætte ordet, som din makker har valgt: "
                +  skjultOrd + "?" );


    }


    @Override
    public void onClick(View v) {

        String bogstav = ET_spil3.getText().toString();

        if (bogstav.length() != 1) {
            ET_spil3.setError("Skriv præcis ét bogstav!");
            return;
        }
        logik.gætBogstavÆndret(bogstav);
        ET_spil3.setText("");
        ET_spil3.setError(null);


        // opdaterer skærmen
        updateScreen();


        // skjuler tastaturet
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);


    }

    private void updateScreen() {

        TV_spil3.setText("Ordet er: " + logik.getSynligtOrd_spil3());
        TV_spil3.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());


        if (logik.erSpilletVundet()) {

            Intent intent = new Intent(this, MultiplayerVundet.class);
            startActivity(intent);

        }


        if (logik.erSpilletTabt()) {

            Intent intent = new Intent(this, MultiplayerTabt.class);
            startActivity(intent);

        }

        switch (logik.getAntalForkerteBogstaver()){

            case 0:
                IV_spil3.setImageResource(R.drawable.galge);
                break;

            case 1:
                IV_spil3.setImageResource(R.drawable.forkert1);
                break;

            case 2:
                IV_spil3.setImageResource(R.drawable.forkert2);
                break;

            case 3:
                IV_spil3.setImageResource(R.drawable.forkert3);
                break;

            case 4:
                IV_spil3.setImageResource(R.drawable.forkert4);
                break;

            case 5:
                IV_spil3.setImageResource(R.drawable.forkert5);
                break;


            default:
                IV_spil3.setImageResource(R.drawable.forkert6);
        }
    }
}
