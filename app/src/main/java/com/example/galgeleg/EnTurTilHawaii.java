package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EnTurTilHawaii extends AppCompatActivity {

    TextView TV_hawaii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.en_tur_til_hawaii);


        TV_hawaii = findViewById(R.id.TV_hawaii);

        TV_hawaii.setText("Velkommen til Hawaii - er du klar til nye udfordringer?");

    }
}
