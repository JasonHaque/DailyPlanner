package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private EditText signupMail,signupPassword,confirmPassword;
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
    }

    void bindListeners(){
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
