package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;


public class Highscore extends AppCompatActivity implements View.OnClickListener {


    Button testKnap;
    ListView listview;
    int sidsteScore;
    int best1, best2, best3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);


        testKnap = findViewById(R.id.testKnap);
        listview = findViewById(R.id.listview);



        testKnap.setOnClickListener(this);


        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        sidsteScore = preferences.getInt("lastscore", 0);
        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);


        if (sidsteScore > best3){

            best3 = sidsteScore;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.apply();

        }

        if (sidsteScore > best2) {

            int b = best2;
            best2 = sidsteScore;
            best3 = b;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.putInt("best2", best2);
            editor.apply();


        }

        if (sidsteScore > best1) {

            int b = best1;
            best1 = sidsteScore;
            best2 = b;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1", best1);
            editor.apply();


        }

        if (sidsteScore > best1) {

            int b = best1;
            best1 = sidsteScore;
            best2 = b;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1", best1);
            editor.apply();


        }


        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(best1);
        arrayList.add(best2);
        arrayList.add(best3);



        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listview.setAdapter(arrayAdapter);


        if(arrayList.size() > 3){

            listview.removeAllViewsInLayout();
            arrayAdapter.clear();

        }





    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, Next_level.class);
        startActivity(intent);


    }
}
