package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText signupMail,signupPassword,confirmPassword;
    private ProgressDialog progressDialog;
    private Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindWidgets();
        bindListeners();
    }

    void bindWidgets(){
        signupMail=findViewById(R.id.signup_mail);
        signupPassword=findViewById(R.id.signup_password);
        confirmPassword=findViewById(R.id.confirm_signup_password);
        signUp=findViewById(R.id.signup_button);
        progressDialog=new ProgressDialog(this);
    }

    void bindListeners(){
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initiateSignUp();

            }
        });
    }

    void initiateSignUp(){
        String email=signupMail.getText().toString();
        String password=signupPassword.getText().toString();
        String confirm = confirmPassword.getText().toString();
        if(email.isEmpty() || password.isEmpty() || confirm.isEmpty()){
            Toast.makeText(SignUpActivity.this,"Fill up the fields properly", Toast.LENGTH_LONG).show();
            return;
        }
        if(!password.equals(confirm)){
            Toast.makeText(SignUpActivity.this,"Passwords do not match", Toast.LENGTH_LONG).show();
            return;
        }
    }
}
