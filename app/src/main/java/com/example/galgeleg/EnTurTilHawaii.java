package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class EnTurTilHawaii extends AppCompatActivity implements View.OnClickListener {

   Galge_spillogik logik = new Galge_spillogik();
    TextView TV_hawaii;
    ImageView imageV_hawaii;
    TextView TV2_hawaii;
    EditText editText_hawaii;
    Button button_hawaii; Button prøvigen_hawaii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.en_tur_til_hawaii);



        imageV_hawaii = findViewById(R.id.imageV_hawaii);
        TV2_hawaii = findViewById(R.id.TV2_hawaii);
        TV2_hawaii.setText("Velkommen til den flotte ø, Hawaii!" +
                "\nKan du gætte ordet: " + logik.getSynligtOrd());


        editText_hawaii = findViewById(R.id.editText_hawaii);


        prøvigen_hawaii = findViewById(R.id.prøvigen_hawaii);

        prøvigen_hawaii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity();


            }
        });



        button_hawaii = findViewById(R.id.button_hawaii);

        button_hawaii.setOnClickListener(this);




        TV_hawaii = findViewById(R.id.TV_hawaii);
        TV_hawaii.setText("HAWAII!");


        final MediaPlayer mp = MediaPlayer.create(this,R.raw.ocean_sound);
        mp.start();

        Handler handler = new Handler();
        Runnable stopPlaybackRun = new Runnable() {
            @Override
            public void run() {

                mp.stop();

            }
        };


        handler.postDelayed(stopPlaybackRun, 3000); //Afspiller lyden i 3 sekunder.

    }

    private void openActivity() {

        Intent intent = new Intent(this, EnTurTilHawaii.class);
        startActivity(intent);

    }


    @Override
    public void onClick(View view) {


        String bogstav = editText_hawaii.getText().toString();

        if (bogstav.length() != 1) {
            editText_hawaii.setError("Skriv præcis ét bogstav!");
            return;
        }
        logik.gætBogstav(bogstav);
        editText_hawaii.setText("");
        editText_hawaii.setError(null);

        // opdaterer skærmen
        updateScreen();

        // skjuler tastaturet
        button_hawaii.onEditorAction(EditorInfo.IME_ACTION_DONE);

    }



    private void updateScreen() {

        TV2_hawaii.setText("Ordet er: " + logik.getSynligtOrd());
        TV2_hawaii.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());


        if (logik.erSpilletVundet()) {

            TV2_hawaii.setText("Du har vundet!");

        }


        if (logik.erSpilletTabt()) {

            TV2_hawaii.setText("Du har tabt! - prøv igen");


        }


        // Ville prøve med switch i stedet for if-statements
    switch(logik.getAntalForkerteBogstaver()){

        case 1:
            imageV_hawaii.setImageResource(R.drawable.forkert1);
            break;


        case 2:
            imageV_hawaii.setImageResource(R.drawable.forkert2);
            break;


        case 3:
            imageV_hawaii.setImageResource(R.drawable.forkert3);
            break;


        case 4:
            imageV_hawaii.setImageResource(R.drawable.forkert4);
            break;


        case 5:
            imageV_hawaii.setImageResource(R.drawable.forkert5);
            break;


        case 6:
            imageV_hawaii.setImageResource(R.drawable.forkert6);
            break;


        default:
            imageV_hawaii.setImageResource(R.drawable.galge);


        }
    }
}
