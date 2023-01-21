package com.example.oakridge;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.oakridge.crisp.client.ChatActivity;

public class   MainActivityMessaging extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_messaging_dementia);
        findViewById(R.id.crisp_button).setOnClickListener(v -> {
           // Intent crispIntent = new Intent(MainActivityMessaging.this, ChatActivity.class);
           // startActivity(crispIntent);
        });
    }
}
