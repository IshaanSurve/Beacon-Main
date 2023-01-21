package com.example.oakridge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText name;
   // EditText lastName;

    CheckBox Patient;
    CheckBox Guardian;
    EditText email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        name = findViewById(R.id.Name);
        //lastName = findViewById(R.id.lastName);
        Guardian = findViewById(R.id.guardian);
        Patient = findViewById(R.id.patient);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
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
}