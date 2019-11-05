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


public class Next_level extends AppCompatActivity implements View.OnClickListener {


    Galge_spillogik logik = new Galge_spillogik();
    HentOrdRegneark hentOrd = new HentOrdRegneark();

    Button prøv_igen; Button prøv_knap_hawaii;
    ImageView galge_billederne;
    EditText editText_hawaii;
    TextView TV_hawaii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_level);


        prøv_igen = findViewById(R.id.prøv_igen);
        prøv_knap_hawaii = findViewById(R.id.prøv_knap_hawaii);
        galge_billederne = findViewById(R.id.galge_billederne);
        editText_hawaii = findViewById(R.id.editText_hawaii);
        TV_hawaii = findViewById(R.id.TV_hawaii);


        prøv_knap_hawaii.setOnClickListener(this);


        // Melder null
        TV_hawaii.setText("Ordet er: " + hentOrd.brugbareOrd);


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
        prøv_knap_hawaii.onEditorAction(EditorInfo.IME_ACTION_DONE);

    }


    private void updateScreen() {






        switch (logik.getAntalForkerteBogstaver()){

            case 1:
                galge_billederne.setImageResource(R.drawable.forkert1);
                break;

            case 2:
                galge_billederne.setImageResource(R.drawable.forkert2);
                break;

            case 3:
                galge_billederne.setImageResource(R.drawable.forkert3);
                break;

            case 4:
                galge_billederne.setImageResource(R.drawable.forkert4);
                break;

            case 5:
                galge_billederne.setImageResource(R.drawable.forkert5);
                break;


            default:
                galge_billederne.setImageResource(R.drawable.forkert6);

        }

    }
}
