package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Next_Level extends AppCompatActivity {

    Galge_spillogik logik = new Galge_spillogik();
    ImageView IV_nextL;
    Button Knap_nextL;
    TextView TV_nextL;
    EditText ET_nextL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_level);




/*


switch (logik.getAntalForkerteBogstaver()){

            case 1:
                IV_nextL.setImageResource(R.drawable.forkert1);
                break;

            case 2:
                IV_nextL.setImageResource(R.drawable.forkert2);
                break;

            case 3:
                IV_nextL.setImageResource(R.drawable.forkert3);
                break;

            case 4:
                IV_nextL.setImageResource(R.drawable.forkert4);
                break;

            case 5:
                IV_nextL.setImageResource(R.drawable.forkert5);
                break;


                default:
                IV_nextL.setImageResource(R.drawable.forkert6);

        }

 */


    }
}
