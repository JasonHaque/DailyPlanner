package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class NoteHistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    private ArrayList<NewNote> noteArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_history);

        recyclerView=findViewById(R.id.recyclerViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteArrayList = new ArrayList<>();
        adapter = new NoteAdapter(this, noteArrayList);
        recyclerView.setAdapter(adapter);
        createlistData();

    }
    private void createlistData(){
        NewNote note =new NewNote("bla bla ","bla bla bla bla");
        noteArrayList.add(note);
        note =new NewNote("la bla ","la bla bla");
        noteArrayList.add(note);
        note =new NewNote("bla bla ","bla bla bla bla");
        noteArrayList.add(note);
    }
}
