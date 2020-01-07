package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.galgeleg.Logik.Logik;


public class Galge_spillet extends AppCompatActivity implements View.OnClickListener {

    Logik logik = new Logik();
    private TextView TV_galgespil2;
    private EditText editText_galgespil2;
    private Button prøv_galgespil2, prøvIgen_galgespil2;
    private ImageView imageView_galgespil2;
    AsyncTask asyncTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galge_spillet);

        logik.logStatus();

        TV_galgespil2 = findViewById(R.id.TV_galgespil2);
        editText_galgespil2 = findViewById(R.id.editText_galgespil2);
        prøv_galgespil2 = findViewById(R.id.prøv_galgespil2);
        prøvIgen_galgespil2 = findViewById(R.id.prøvIgen_galgespil2);
        imageView_galgespil2 = findViewById(R.id.imageView_galgespil2);

        prøv_galgespil2.setOnClickListener(this);

        prøvIgen_galgespil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                genstartSpil();

            }
        });


        Toast.makeText(Galge_spillet.this, "Henter ord fra DR...", //Viser en besked, inden ordet hentes fra DR
                Toast.LENGTH_SHORT).show();





        // henter ord fra DR
        asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    Thread.sleep(1000);
                    logik.hentOrdFraDr();
                    return "Ord hentet fra DR!";

                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                    return "Ordet blev ikke hentet!" + e;

                }
            }

            @Override
            protected void onPostExecute(Object o) {
                TV_galgespil2.setText("VELKOMMEN TIL NÆSTE LEVEL!"
                        + "\n\n Dit nye ord er: " + logik.getSynligtOrd());
                logik.logStatus();
            }
        }.execute();

    }

    private void genstartSpil() {

        Intent intent = new Intent(this, Galge_spillet.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onClick(View v) {

        String bogstav = editText_galgespil2.getText().toString();

        if (bogstav.length() != 1) {
            editText_galgespil2.setError("Skriv præcis ét bogstav!");
            return;
        }

        logik.gætBogstav(bogstav);
        editText_galgespil2.setText("");
        editText_galgespil2.setError(null);


        // metode til at opdatere skærmen
        updateScreen();


        // skjuler tastaturet
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);



    }

    private void updateScreen() {

        TV_galgespil2.setText("Ordet er: " + logik.getSynligtOrd());
        TV_galgespil2.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());


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
                imageView_galgespil2.setImageResource(R.drawable.galge);
                break;

            case 1:
                imageView_galgespil2.setImageResource(R.drawable.forkert1);
                break;

            case 2:
                imageView_galgespil2.setImageResource(R.drawable.forkert2);
                break;

            case 3:
                imageView_galgespil2.setImageResource(R.drawable.forkert3);
                break;

            case 4:
                imageView_galgespil2.setImageResource(R.drawable.forkert4);
                break;

            case 5:
                imageView_galgespil2.setImageResource(R.drawable.forkert5);
                break;


            default:
                imageView_galgespil2.setImageResource(R.drawable.forkert6);
        }
    }
}

