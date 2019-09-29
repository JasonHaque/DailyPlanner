package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.dailyplanner.LogInActivity.userID;

public class ProfileActivity extends AppCompatActivity {

    private Button logout;
    private FirebaseAuth firebaseAuth;
    private TextView userView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bindWidgets();
        bindListeners();
        userView.setText("Welcome User"+userID);
    }

    void bindWidgets(){
        logout=findViewById(R.id.log_out);
        firebaseAuth=FirebaseAuth.getInstance();
        userView=findViewById(R.id.user_view);

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
