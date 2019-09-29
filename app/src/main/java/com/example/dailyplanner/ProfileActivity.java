package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

    private Button logout;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bindWidgets();
        bindListeners();
    }

    void bindWidgets(){
        logout=findViewById(R.id.log_out);
        firebaseAuth=FirebaseAuth.getInstance();
    }
    void bindListeners(){
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                startActivity(new Intent(ProfileActivity.this,LogInActivity.class));
            }
        });
    }
}
