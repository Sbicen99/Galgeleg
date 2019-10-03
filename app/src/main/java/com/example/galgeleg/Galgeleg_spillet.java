package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class Galgeleg_spillet extends AppCompatActivity implements View.OnClickListener {

    Galge_spillogik logik = new Galge_spillogik();
    private TextView TV;
    private Button spilKnap;
    private EditText ET;
    private ImageView image;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Programmatisk layout
        TableLayout t1 = new TableLayout(this);

        TV = new TextView(this);
        TV.setText("Velkommen." +
                "\nKan du gætte dette ord: " + logik.getSynligtOrd() + "?"
                + "\nSkriv ét og kun ét bogstav herunder og tryk 'Spil'. \n");

        String velkomst = getIntent().getStringExtra("velkomst");
        if (velkomst != null) TV.append(velkomst);
        t1.addView(TV);


        ET = new EditText(this);
        ET.setHint("Skriv ét bogstav her");
        t1.addView(ET);


        spilKnap = new Button(this);
        spilKnap.setText("Spil");
        spilKnap.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_media_play, 0, 0, 0);
        t1.addView(spilKnap);


        spilKnap.setOnClickListener(this);

        image = new ImageView(this);
        image.setImageResource(R.drawable.galge);
        t1.addView(image);



        setContentView(t1);
        logik.logStatus();


    }

    @Override
    public void onClick(View view) {

        String bogstav = ET.getText().toString();
        if (bogstav.length() != 1) {
            ET.setError("Husk, det skal være ét bogstav");
            return;


        }

        logik.gætBogstav(bogstav);
        ET.setText("");
        ET.setError(null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {

        }

        opdaterSkærm();
    }


    private void opdaterSkærm() {

        TV.setText("Gæt ordet: " + logik.getSynligtOrd());
        TV.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());


        if (logik.erSpilletVundet()) {
            TV.append("\nDu har vundet!");
            image.setImageResource(R.drawable.pokal1);


        }

        if (logik.erSpilletTabt()) {
            TV.setText("Du har tabt, ordet var: " + logik.getOrdet());
            image.setImageResource(R.drawable.forkert6);


        } if (logik.erSpilletTabt() == true) {

            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

        if (logik.getAntalForkerteBogstaver() == 1) {

            image.setImageResource(R.drawable.forkert1);

        } else if (logik.getAntalForkerteBogstaver() == 2){

            image.setImageResource(R.drawable.forkert2);

        } else if (logik.getAntalForkerteBogstaver() == 3){

            image.setImageResource(R.drawable.forkert3);

        } else if (logik.getAntalForkerteBogstaver() == 4){

            image.setImageResource(R.drawable.forkert4);

        } else if (logik.getAntalForkerteBogstaver() == 5){

            image.setImageResource(R.drawable.forkert5);

        }
    }
}
















