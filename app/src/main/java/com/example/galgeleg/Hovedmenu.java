package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Hovedmenu extends AppCompatActivity implements View.OnClickListener {

Button minKnap1; Button hjælpKnap; Button tester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hovedmenu);


        minKnap1 = findViewById(R.id.minKnap1);
        hjælpKnap = findViewById(R.id.hjælpKnap2);
        tester = findViewById(R.id.tester);



        minKnap1.setOnClickListener(this);
        tester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                testActivity();

            }
        });
        hjælpKnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity2();


            }
        });


    }

    //Test - også XML-filen
    private void testActivity() {

        Intent test = new Intent(this, Test_klasse.class);
        startActivity(test);

    }


    private void openActivity2() {

        Intent in = new Intent(this, Hjaelp.class);
        startActivity(in);


    }


    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, Galge_spillet.class);
        startActivity(i);


    }
}