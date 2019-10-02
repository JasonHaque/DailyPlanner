package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.example.dailyplanner.NewNoteActivity.snote;

public class SuccessfulNote extends AppCompatActivity {
    private TextView successfulNoteName,successfulNoteContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_note);
        bindWidgets();
        bindListeners();
        successfulNoteName.setText(snote.name);
        successfulNoteContent.setText(snote.content);

    }

    private void bindWidgets(){
        successfulNoteName=findViewById(R.id.successful_note_name);
        successfulNoteContent=findViewById(R.id.successful_note_content);
        //dref=FirebaseDatabase.getInstance().getReference().child(userID).child(sendNoteName+userID);
    }

    private void bindListeners(){

    }
}
