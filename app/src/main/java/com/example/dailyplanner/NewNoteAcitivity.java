package com.example.dailyplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.dailyplanner.LogInActivity.userID;

public class NewNoteAcitivity extends AppCompatActivity {

    private Button setNoteButton,saveNoteButton,cancel;
    private EditText note,setNoteName;
    private TextView noteName;
    private DatabaseReference dref;
    private ProgressDialog progressDialog;

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
        dref= FirebaseDatabase.getInstance().getReference();
        progressDialog=new ProgressDialog(this);
    }

    private void bindListeners(){
        setNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameOfNote =setNoteName.getText().toString();
                if(nameOfNote.isEmpty()){
                    Toast.makeText(NewNoteAcitivity.this,"Enter a note name",Toast.LENGTH_LONG).show();
                    return;
                }
                noteName.setText(nameOfNote);
                noteName.setVisibility(View.VISIBLE);
                setNoteButton.setVisibility(View.INVISIBLE);
                setNoteName.setVisibility(View.INVISIBLE);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewNoteAcitivity.this,NotesActivity.class));
            }
        });
        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noteName = setNoteName.getText().toString().trim();
                String noteContent=note.getText().toString();
                NewNote userNote = new NewNote(noteName,noteContent);
                progressDialog.setTitle("Saving");
                progressDialog.show();
                dref.child(userID).child("Notes").setValue(userNote).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progressDialog.dismiss();
                        Toast.makeText(NewNoteAcitivity.this,"Success",Toast.LENGTH_LONG).show();


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(NewNoteAcitivity.this,"Failed",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
