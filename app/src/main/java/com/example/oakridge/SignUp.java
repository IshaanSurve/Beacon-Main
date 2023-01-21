package com.example.oakridge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText name;
   // EditText lastName;

    //CheckBox Patient;
    CheckBox Guardian;
    EditText email;
    EditText password;
    Button register;

    boolean isGuardian;

    FirebaseAuth fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        name = findViewById(R.id.Name);
        //lastName = findViewById(R.id.lastName);
        Guardian = findViewById(R.id.guardian);

       // Patient = findViewById(R.id.patient);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);
        password = findViewById(R.id.password2);
        fa = FirebaseAuth.getInstance();
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

    public void register(View v){
        checkDataEntered();
        isGuardian = Guardian.isChecked();
        String n = name.getText().toString();
        String e = email.getText().toString();
        String psw = password.getText().toString();
            //Guardian g = new Guardian(n,e,psw);
            fa.createUserWithEmailAndPassword(e,psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignUp.this, "You are successfully Registered", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUp.this, "You are not Registered! Try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            //Patient p = new Patient(n,e,psw)
    }
}
