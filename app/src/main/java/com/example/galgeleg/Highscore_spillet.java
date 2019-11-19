package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;


public class Highscore_spillet extends AppCompatActivity implements View.OnClickListener {

    ImageView tilbage_K;
    ListView listview1, listview2;
    int sidsteScore, best1, best2, best3, best4, best5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore_spillet);


        tilbage_K = findViewById(R.id.tilbage_K);

        tilbage_K.setOnClickListener(this);


        listview1 = findViewById(R.id.listview1);
        listview2 = findViewById(R.id.listview2);


            SharedPreferences preferences = getSharedPreferences("PREFS", 0);
            sidsteScore = preferences.getInt("lastscore", 0);
            best1 = preferences.getInt("best1", 0);
            best2 = preferences.getInt("best2", 0);
            best3 = preferences.getInt("best3", 0);
            best4 = preferences.getInt("best4", 0);
            best5 = preferences.getInt("best5", 0);



        if (sidsteScore > best5) {

            best5 = sidsteScore;

           SharedPreferences.Editor editor = preferences.edit();
           editor.putInt("best5", best5);
           editor.apply();

        }

        if (sidsteScore > best4) {

            int s4 = best4;
            best4 = sidsteScore;
            best5 = s4;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best5", best5);
            editor.putInt("best4", best4);
            editor.apply();



        }
        if (sidsteScore > best3) {

            int s3 = best3;
            best3 = sidsteScore;
            best4 = s3;

          SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best4", best4);
            editor.putInt("best3", best3);
            editor.apply();



        }

        if (sidsteScore > best2) {

            int s2 = best2;
            best2 = sidsteScore;
            best3 = s2;


            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.putInt("best2", best2);
            editor.apply();

        }

        if (sidsteScore > best1) {

            int s1 = best1;
            best1 = sidsteScore;
            best2 = s1;


            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1", best1);
            editor.apply();



        }


        ArrayList<String> arrayList2 = new ArrayList<>();

        arrayList2.add("Score 1: ");
        arrayList2.add("Score 2: ");
        arrayList2.add("Score 3: ");
        arrayList2.add("Score 4: ");
        arrayList2.add("Score 5: ");


        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList2);

        listview2.setAdapter(arrayAdapter2);


        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(best1);
        arrayList.add(best2);
        arrayList.add(best3);
        arrayList.add(best4);
        arrayList.add(best5);


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listview1.setAdapter(arrayAdapter);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, Galgespillet2.class);
        startActivity(intent);
        finish();


    }
}
