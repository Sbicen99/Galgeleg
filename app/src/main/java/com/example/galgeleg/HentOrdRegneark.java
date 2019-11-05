package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;


import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import java.lang.ref.WeakReference;

// Fået inspiration fra Discord-serveren: #DTU Software Diplom
// Brugbar link: https://stackoverflow.com/questions/38627850/asynctask-doinbackground-downloading-google-spreadsheets-data-returning-null
// Mener at der skal bruges threats, men har ikke lige 'fanget' den endnu - spørg hjælpelærere i afleveringen til d. 6.

public class HentOrdRegneark extends AppCompatActivity {


    Galge_spillogik logik = new Galge_spillogik();

    public TextView brugbareOrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hentordfregneark);


        new GetWordTask(this, logik).execute();

    }

    private void setRandomOrd() {
        brugbareOrd.setText(logik.getOrdet());
    }


    private void showErrorMessage() {
        brugbareOrd.setText("Kunne ikke finde et ord");
    }


    private static class GetWordTask extends AsyncTask<String, String, Exception> {

        private final WeakReference<HentOrdRegneark> aktivitetsreference;
        private final Galge_spillogik logik;

        GetWordTask(HentOrdRegneark aktivitet, Galge_spillogik logik) {
            this.aktivitetsreference = new WeakReference<>(aktivitet);
            this.logik = logik;

        }

        @Override
        protected Exception doInBackground(String... strings) {
            try {
                logik.hentOrdFraRegneark("1");
            } catch (Exception e) {
                return e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Exception e) {
            if (aktivitetsreference.get() != null) {
                if (e != null) {
                    aktivitetsreference.get().showErrorMessage();
                } else {
                    aktivitetsreference.get().setRandomOrd();
                }
            }
        }
    }
}
    

