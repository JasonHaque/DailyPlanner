package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.dailyplanner.NewNoteActivity.snote;

public class SuccessfulNote extends AppCompatActivity {
    private TextView successfulNoteName,successfulNoteContent;
    private Button back;
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
        back=findViewById(R.id.backn_button);
        //dref=FirebaseDatabase.getInstance().getReference().child(userID).child(sendNoteName+userID);
    }

    private void bindListeners(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SuccessfulNote.this,NotesActivity.class));
            }
        });

    }
}
