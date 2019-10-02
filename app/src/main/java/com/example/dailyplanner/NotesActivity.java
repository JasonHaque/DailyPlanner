package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class NotesActivity extends AppCompatActivity {

    private ImageButton linkToProfile1,newNote1,noteHistory1,schedule1,seeSchedule1;
    private Button linkToProfile2,newNote2,noteHistory2,schedule2,seeSchedule2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        bindWidgets();
        bindListeners();
    }
    private void bindWidgets()
    {
        linkToProfile1=findViewById(R.id.link_to_profile1);
        newNote1=findViewById(R.id.new_note1);
        noteHistory1=findViewById(R.id.note_history1);
        schedule1=findViewById(R.id.schedule1);
        seeSchedule1=findViewById(R.id.see_schedule1);
        linkToProfile2=findViewById(R.id.link_to_profile2);
        newNote2=findViewById(R.id.new_note2);
        noteHistory2=findViewById(R.id.note_history2);
        schedule2=findViewById(R.id.schedule2);
        seeSchedule2=findViewById(R.id.see_schedule2);
    }
    private void bindListeners(){
        linkToProfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this,ProfileActivity.class));
            }
        });
        newNote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this, NewNoteActivity.class));
            }
        });
        noteHistory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this,NoteHistoryActivity.class));
            }
        });
        schedule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this,ScheduleActivity.class));
            }
        });
        seeSchedule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this,SeeScheduleActivity.class));
            }
        });
        linkToProfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this,ProfileActivity.class));
            }
        });
        newNote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this, NewNoteActivity.class));
            }
        });
        noteHistory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this,NoteHistoryActivity.class));
            }
        });
        schedule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this,ScheduleActivity.class));
            }
        });
        seeSchedule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this,SeeScheduleActivity.class));
            }
        });
    }
}
