package com.example.oakridge;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Medical_Repository extends AppCompatActivity {

    public FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical_questions_patients);
    }

    public void onClickUserMedicalInfo(View v){

        userID = UID.getId();
        EditText nameField = findViewById(R.id.Name);
        EditText ageField = findViewById(R.id.age);
        EditText allergiesField = findViewById(R.id.allergiesinput);
        EditText heightField = findViewById(R.id.height);
        EditText weightField = findViewById(R.id.weight);
        EditText otherField = findViewById(R.id.addinfo);

        String Name = nameField.getText().toString();
        String Age = ageField.getText().toString();
        String Weight = weightField.getText().toString();
        String Allergies = allergiesField.toString();
        String Height = heightField.getText().toString();
        String Other = otherField.toString();

        DocumentReference doc = fStore.collection("users").document(userID);



    }
}