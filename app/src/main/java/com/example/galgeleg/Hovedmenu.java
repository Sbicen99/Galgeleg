package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Hovedmenu extends AppCompatActivity implements View.OnClickListener {

ImageView spil_Knap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forside);


        spil_Knap = findViewById(R.id.spil_Knap);

        spil_Knap.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, Galge_spillet.class);
        startActivity(i);

    }
}