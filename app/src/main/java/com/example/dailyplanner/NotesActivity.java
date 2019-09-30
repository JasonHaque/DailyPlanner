package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotesActivity extends AppCompatActivity {

    private Button linkToProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        bindWidgets();
        bindListeners();
    }
    private void bindWidgets()
    {
        linkToProfile=findViewById(R.id.link_to_profile);
    }
    private void bindListeners(){
        linkToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this,ProfileActivity.class));
            }
        });
    }
}
