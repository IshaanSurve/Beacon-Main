package com.example.oakridge;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.oakridge.R;


public class progressbarshi extends AppCompatActivity {

    private int CurrentProgress = 0;
    private ProgressBar progressBar;
    private Button startProgress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mental_health);

        progressBar = findViewById(R.id.progressBar);
        startProgress = findViewById(R.id.increase);

        startProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CurrentProgress = CurrentProgress + 10;
                progressBar.setProgress(CurrentProgress);
                progressBar.setMax(100);
            }
        });




    }
}