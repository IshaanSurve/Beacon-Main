package com.example.oakridge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signIn(View v) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("server/saving-data/fireblog");
        EditText nameField = findViewById(R.id.Name);
        EditText passwordField = findViewById(R.id.password);
        EditText emailField = findViewById(R.id.email);
       // EditText phoneNumberField = findViewById(R.id.phoneNumber);
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
       // int phoneNumber = Integer.parseInt(phoneNumberField.getText().toString());

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        Log.d("Info", "done");
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Account exists and password is correct
                            Log.d("LOGIN", "Successful login");
                        } else {
                            // Account does not exist or password is incorrect
                            Log.d("LOGIN", "Failed login");
                        }
                    }
                });
    }

    public void register(View v){

    }


}

