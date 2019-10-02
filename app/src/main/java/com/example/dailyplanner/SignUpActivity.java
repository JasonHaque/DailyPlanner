package com.example.dailyplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText signupMail, signupPassword, confirmPassword;
    private ProgressDialog progressDialog;
    private Button signUp,backButton;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindWidgets();
        bindListeners();
    }

    void bindWidgets() {
        signupMail = findViewById(R.id.signup_mail);
        signupPassword = findViewById(R.id.signup_password);
        confirmPassword = findViewById(R.id.confirm_signup_password);
        signUp = findViewById(R.id.signup_button);
        backButton = findViewById(R.id.backlogin_button);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    void bindListeners() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initiateSignUp();

            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LogInActivity.class));
            }
        });
    }

    private void initiateSignUp() {
        String email = signupMail.getText().toString();
        String password = signupPassword.getText().toString();
        String confirm = confirmPassword.getText().toString();
        if (email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Fill up the fields properly", Toast.LENGTH_LONG).show();
            return;
        }
        if (!password.equals(confirm)) {
            Toast.makeText(SignUpActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();
            return;
        }
        SignUp(email, password);
    }

    private void SignUp(String email, String password) {
        progressDialog.setTitle("Signing You In");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
                startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUpActivity.this, "Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
