package com.example.oakridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Dementia_Home extends AppCompatActivity {
    //Button call;
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


    public void openMedicalRepo(View v){
        Intent myIntent = new Intent(v.getContext(), Medical_Repository.class);
        startActivityForResult(myIntent, 0);
    }


    public void openMemories(View v){
        Intent myIntent = new Intent(v.getContext(), memo_repo.class);
        startActivityForResult(myIntent, 0);
    }

    public void openSOS(View v){
        Intent myIntent = new Intent(v.getContext(), SOS_MainActivity.class);
        startActivity(myIntent);
    }

    public void openChat(View v){
        //Intent myIntent = new Intent(v.getContext(), MainActivityMessaging.class);
        //  startActivityForResult(myIntent, 0);
    }

    public void openRemainder(View v){
        Intent myIntent = new Intent(v.getContext(), MainReminderActivity.class);
    }

    public void logout(View v){
        FirebaseAuth.getInstance().signOut();
    }
}