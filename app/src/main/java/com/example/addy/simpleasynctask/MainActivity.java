package com.example.addy.simpleasynctask;

/*
* AsyncTask
* executing task in parallel thread
* methods doInBackground, onPreExecute, onPostExecute
* */

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    MyTask myTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
    }

    public void onclick(View view){
        myTask = new MyTask();
        myTask.execute();
    }

    class MyTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try{
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("begin");
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            textView.setText(R.string.end);
        }
    }
}
