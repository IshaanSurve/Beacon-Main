package com.example.oakridge;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Medical_Repository extends AppCompatActivity {

    public FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    public FirebaseAuth fa = FirebaseAuth.getInstance();
    String userID;

    public TextView info;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical_questions_patients);
        info = findViewById(R.id.Medical_Info);
    }

    public void onClickUserMedicalInfo(View v) {
        FirebaseUser currUser = fa.getCurrentUser();
        userID = currUser.getUid();
        EditText nameField = findViewById(R.id.name);
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
        doc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                Log.d("Success", "YES");
                if (task.isSuccessful()) {
                    //Log.d("Again", "YES");
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Map<String, Object> user = document.getData();
                        user.put("fAllergies", Allergies);
                        user.put("fWeight", Weight);
                        user.put("fAge", Age);
                        user.put("fHeight", Height);
                        user.put("fName", Name);
                        user.put("fAdditionalInfo", Other);
                    }
                }

            }
        });


    }
    public void outputAll(View v){
        DocumentReference doc = fStore.collection("users").document(userID);
        doc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Map<String, Object> user = document.getData();
                        String medical_info = "Patient Name: " +  user.get("fName") + "\n Patient Age" + user.get("fAge") + "\n Patient Weight" +  user.get("fWeight") + "\n Patient Height" + user.get("fHeight") + "\n Allergies: " + user.get("fAllergies") + "\n Extra Information" + user.get("fAdditionalInfo");
                        info.setText(medical_info);
                    }
                }
    }
});
    }
}