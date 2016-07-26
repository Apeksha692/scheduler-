package com.example.chidambar.projectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



    public class MainActivity extends AppCompatActivity implements Runnable {
        private Thread mobjThread;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mobjThread = new Thread(this);
            mobjThread.start();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);

                startActivity(new Intent(this, Main2Activity.class));
                this.finish();


            } catch (InterruptedException e) {

            }

        }
    }





