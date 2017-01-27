package es.cice.progressbarrace;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Maneja la progresion de un ProgressBar. La actividad maneja un grupo de ProgressBar indentificados por un
     * indice [0...max]. El primer generico del AsyncTask determina el indice del Progressbar que va a controlar
     * El segundo generico se usa para señalar el progreso del ProgressBar bajo control
     * El ultimo generico, el valor final del AsyncTask cuando haya concluido su trabajo, señala el indice
     * del ProgressBar que ha terminado
     */
    public class ProgressBarRaceAsyncTask extends AsyncTask<Integer,Integer,Integer> {

        @Override
        protected Integer doInBackground(Integer... integers) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }
    }
}
