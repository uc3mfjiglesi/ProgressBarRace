package es.cice.progressbarrace;

import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar[] pBars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TypedArray pBarArray=getResources().obtainTypedArray(R.array.progressBarIds);
        pBars=new ProgressBar[pBarArray.length()];
        for(int i=0;i<pBars.length;i++){
            pBars[i]= (ProgressBar) findViewById(pBarArray.getResourceId(i,0));
            pBars[i].setMax((int)getResources().getInteger(R.integer.pBarMax));
        }

    }

    public void startRace(View v){

    }

    /**
     * Maneja la progresion de un ProgressBar. La actividad maneja un grupo de ProgressBar indentificados por un
     * indice [0...max]. El primer generico del AsyncTask determina el indice del Progressbar que va a controlar
     * El segundo generico se usa para señalar el progreso del ProgressBar bajo control
     * El ultimo generico, el valor final del AsyncTask cuando haya concluido su trabajo, señala el indice
     * del ProgressBar que ha terminado
     */
    public class ProgressBarRaceAsyncTask extends AsyncTask<Integer,Integer,Integer> {
        private int pBarIndex;
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
