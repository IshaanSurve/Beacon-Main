package com.example.oakridge;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    EditText name;
   // EditText lastName;

    //CheckBox Patient;
   // CheckBox Guardian;
    EditText email;
    EditText password;
    Button register;

    EditText phoneNumber;
    boolean isGuardian;

    //boolean isGuardian;

    FirebaseAuth fa;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        name = findViewById(R.id.Name);
        //lastName = findViewById(R.id.lastName);
        //Guardian = findViewById(R.id.guardian);

       // Patient = findViewById(R.id.patient);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);
        password = findViewById(R.id.password2);
        fa = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        phoneNumber = findViewById(R.id.phone);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(name)) {
            Toast t = Toast.makeText(this, "You must enter name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        }
    }

    public void signIn(View v){

        Log.d("Working", "YES");
        checkDataEntered();
       // isGuardian = Guardian.isChecked();
        String n = name.getText().toString();
        String e = email.getText().toString();
        String psw = password.getText().toString();

        String phone_number = phoneNumber.getText().toString();
            //Guardian g = new Guardian(n,e,psw);

            if(e != null && psw != null) {
                fa.createUserWithEmailAndPassword(e, psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "You are successfully Registered", Toast.LENGTH_SHORT).show();
                            userID = fa.getCurrentUser().getUid();
                            DocumentReference doc = fStore.collection("users").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            UID.set(userID);
                            user.put("fName", n);
                            user.put("fEmail", e);
                            user.put("fPhoneNo", phone_number);
                            user.put("fAllergies", "");
                            user.put("fHeight", "0");
                            user.put("fWeight", 0);
                            user.put("fAdditionalInfo", "");
                            user.put("fAge", "0");
                            doc.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG, "OnSuccess: user profile is created for " + userID);
                                }


                                //DocumentReference userStatus = fStore.collection("users").document("status");


                            });

                        } else {
                            Toast.makeText(SignUp.this, "You are not Registered! Try again", Toast.LENGTH_SHORT).show();
                        }

                        Intent myIntent = new Intent(v.getContext(), Dementia_Home.class);
                        startActivityForResult(myIntent, 0);
                    }
                });
            }
            //Patient p = new Patient(n,e,psw)
    }


}
