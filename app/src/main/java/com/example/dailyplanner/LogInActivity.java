package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {

    private Button directToSignup,loginButton;
    private EditText loginMail,loginPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        bindWidgets();
        bindListeners();
    }
    void bindWidgets(){
        directToSignup=findViewById(R.id.signup_transfer);
        loginMail=findViewById(R.id.login_mail);
        loginPassword=findViewById(R.id.login_password);
        loginButton=findViewById(R.id.login_button);
    }

    void bindListeners(){
        directToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this,SignUpActivity.class));
            }
        });
    }
}
