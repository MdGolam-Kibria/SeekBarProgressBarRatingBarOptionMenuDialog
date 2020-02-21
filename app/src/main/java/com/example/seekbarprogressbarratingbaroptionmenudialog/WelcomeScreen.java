package com.example.seekbarprogressbarratingbaroptionmenudialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class WelcomeScreen extends AppCompatActivity {
    private ProgressBar progrebarForWelcome;
    private int progressDefaultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        progrebarForWelcome = (ProgressBar) findViewById(R.id.progrebarForWelcome);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                changeActivity();
            }
        });
        thread.start();
    }

    private void doWork() {
        for (progressDefaultValue = 20; progressDefaultValue < 100; progressDefaultValue += 20) {
            try {
                Thread.sleep(1000);
                progrebarForWelcome.setProgress(progressDefaultValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeActivity() {
        Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
        startActivity(intent);
    }
}
