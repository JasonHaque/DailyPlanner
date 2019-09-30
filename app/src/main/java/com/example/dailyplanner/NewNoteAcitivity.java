package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewNoteAcitivity extends AppCompatActivity {

    private Button setNoteButton,saveNoteButton,cancel;
    private EditText note,setNoteName;
    private TextView noteName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note_acitivity);
        bindWidgets();
        bindListeners();
    }
    private void bindWidgets(){
        setNoteButton=findViewById(R.id.set_note_button);
        saveNoteButton=findViewById(R.id.save_note_button);
        cancel=findViewById(R.id.cancel_note);
        note=findViewById(R.id.note);
        setNoteName=findViewById(R.id.set_note_name);
        noteName=findViewById(R.id.note_name);
    }

    private void bindListeners(){

    }
}
