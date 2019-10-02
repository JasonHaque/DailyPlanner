package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SuccessfulNote extends AppCompatActivity {
    private TextView successfulNoteName,successfulNoteContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_note);
        bindWidgets();
        bindListeners();

    }

    private void bindWidgets(){
        successfulNoteName=findViewById(R.id.successful_note_name);
        successfulNoteContent=findViewById(R.id.successful_note_content);
    }

    private void bindListeners(){

    }
}
