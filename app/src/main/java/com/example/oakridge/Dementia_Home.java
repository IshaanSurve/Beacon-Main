package com.example.oakridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dementia_Home extends AppCompatActivity {
    Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_patient);
        //call = findViewById(R.id.button12);
    }

    public void openMental(View v){
        Intent myIntent = new Intent(v.getContext(), progressbarshi.class);
        startActivityForResult(myIntent, 0);
    }
}