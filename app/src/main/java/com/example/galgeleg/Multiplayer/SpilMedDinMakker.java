package com.example.galgeleg.Multiplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.galgeleg.R;

import java.util.ArrayList;

public class SpilMedDinMakker extends AppCompatActivity {

    private ListView listView_spil3;
    private Handler handler;
    private Runnable delayRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spil_med_din_makker);


        listView_spil3 = findViewById(R.id.listView_spil3);

        ArrayList<String> arrayList_spil3 = new ArrayList<>();


        arrayList_spil3.add("cykel");
        arrayList_spil3.add("lastbil");
        arrayList_spil3.add("android");
        arrayList_spil3.add("telefon");
        arrayList_spil3.add("motorcykel");
        arrayList_spil3.add("tastatur");
        arrayList_spil3.add("kodestruktur");
        arrayList_spil3.add("dtu");
        arrayList_spil3.add("bus");
        arrayList_spil3.add("java");




        ArrayAdapter arrayAdapter_spil3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList_spil3);

        listView_spil3.setAdapter(arrayAdapter_spil3);


        listView_spil3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String valgtOrd = (String) listView_spil3.getItemAtPosition(position);
                OrdDatabase.valgtord = valgtOrd;
                Toast.makeText(SpilMedDinMakker.this, "Du valgte ordet: " + valgtOrd, Toast.LENGTH_SHORT).show();

                handler = new Handler();
                delayRunnable = new Runnable() {

                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), SpilMedDinMakker_Spillet.class);
                        startActivity(intent);
                    }
                };
                handler.postDelayed(delayRunnable, 1000);

            }
        });




    }
}
