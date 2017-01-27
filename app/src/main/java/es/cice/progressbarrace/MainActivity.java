package es.cice.progressbarrace;

import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity" ;
    private ProgressBar[] pBars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TypedArray pBarArray=getResources().obtainTypedArray(R.array.progressBarIds);
        /*Log.d(TAG,"" + pBarArray);
        pBars=new ProgressBar[pBarArray.length()];
        for(int i=0;i<pBars.length;i++){
            pBars[i]= (ProgressBar) findViewById(pBarArray.getResourceId(i,0));
            Log.d(TAG,"index: " + pBarArray.getResourceId(i,0));
            //pBars[i].setMax((int)getResources().getInteger(R.integer.pBarMax));
        }*/
        pBars=new ProgressBar[10];
        pBars[0]= (ProgressBar) findViewById(R.id.progressBar0);
        pBars[1]= (ProgressBar) findViewById(R.id.progressBar0);
        pBars[2]= (ProgressBar) findViewById(R.id.progressBar0);
        pBars[3]= (ProgressBar) findViewById(R.id.progressBar0);
        pBars[4]= (ProgressBar) findViewById(R.id.progressBar0);
        pBars[5]= (ProgressBar) findViewById(R.id.progressBar0);
        pBars[6]= (ProgressBar) findViewById(R.id.progressBar0);
        pBars[7]= (ProgressBar) findViewById(R.id.progressBar0);
        pBars[8]= (ProgressBar) findViewById(R.id.progressBar0);
        pBars[9]= (ProgressBar) findViewById(R.id.progressBar0);

    }

    public void startRace(View v){
        ProgressBarRaceAsyncTask[] pBarTasks=new ProgressBarRaceAsyncTask[pBars.length];
        for(int i=0;i<pBarTasks.length;i++){
            pBarTasks[i].execute(i);
        }
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
        protected Integer doInBackground(Integer... indexes) {
            if(indexes.length==0)
                return null;
            pBarIndex=indexes[0];
            Random rnd=new Random();
            int progress=0;
            while(progress<R.integer.pBarMax){
                int avance=rnd.nextInt(10);
                publishProgress(avance);
                int sleep=rnd.nextInt(100);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return pBarIndex;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pBars[pBarIndex].setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            pBars[pBarIndex].setVisibility(View.GONE);
        }
    }
}
