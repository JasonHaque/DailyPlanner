package com.example.dailyplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

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
    private void bindWidgets(){
        newNote1=findViewById(R.id.new_note1);
        noteHistory1=findViewById(R.id.note_history1);
        schedule1=findViewById(R.id.schedule1);
        seeSchedule1=findViewById(R.id.see_schedule1);
        newNote2=findViewById(R.id.new_note2);
        noteHistory2=findViewById(R.id.note_history2);
        schedule2=findViewById(R.id.schedule2);
        seeSchedule2=findViewById(R.id.see_schedule2);
    }
    private void bindListeners(){

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
        /*linkToProfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotesActivity.this,ProfileActivity.class));
            }
        });*/
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.log_out_menu:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(NotesActivity.this,LogInActivity.class));
                finish();
                break;
            case R.id.profile_id:
                startActivity(new Intent(NotesActivity.this,ProfileActivity.class));
                break;

        }
        /*if(a == ){
            return true;
        }
        else if(a == ){

        }*/
        return false;
    }
    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
