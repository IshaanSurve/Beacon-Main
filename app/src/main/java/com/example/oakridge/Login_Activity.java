package com.example.oakridge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login_Activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null){
            this.recreate();
        }
    }

    public void signIn(View v) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("server/saving-data/fireblog");
        //EditText nameField = findViewById(R.id.Name);
        EditText passwordField = findViewById(R.id.password);
        EditText emailField = findViewById(R.id.Email);
       // EditText phoneNumberField = findViewById(R.id.phoneNumber);
        //String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
       // int phoneNumber = Integer.parseInt(phoneNumberField.getText().toString());


        Log.d("Info", "done");
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Account exists and password is correct
                            Log.d("LOGIN", "Successful login");
                            Intent myIntent = new Intent(v.getContext(), Dementia_Home.class);
                            startActivityForResult(myIntent, 0);

                        } else {
                            // Account does not exist or password is incorrect
                            Toast.makeText(Login_Activity.this, "You are not Registered! Try again", Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(v.getContext(), Dementia_Home.class);
                            startActivityForResult(myIntent, 0);
                        }
                    }
                });
    }

    public void register(View v){
        Intent myIntent = new Intent(v.getContext(), SignUp.class);
        startActivityForResult(myIntent, 0);
    }


}

