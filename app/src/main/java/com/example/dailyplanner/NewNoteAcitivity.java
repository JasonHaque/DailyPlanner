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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import static com.example.dailyplanner.LogInActivity.userID;

public class NewNoteAcitivity extends AppCompatActivity {

    private Button setNoteButton,saveNoteButton,cancel;
    private EditText note,setNoteName;
    private TextView noteName;
    private DatabaseReference dref;
    private ProgressDialog progressDialog;
    public static String sendNoteName;
    public static NewNote abs;

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
                final String noteName = setNoteName.getText().toString().trim();
                String noteContent=note.getText().toString();
                NewNote userNote = new NewNote(noteName,noteContent);
                sendNoteName=noteName;
                progressDialog.setTitle("Saving");
                progressDialog.show();
                dref.child(userID).child("Notes").child(noteName+userID).setValue(userNote).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progressDialog.dismiss();
                        Toast.makeText(NewNoteAcitivity.this,"Success",Toast.LENGTH_LONG).show();


                        //startActivity(new Intent(NewNoteAcitivity.this,SuccessfulNote.class));



                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(NewNoteAcitivity.this,"Failed",Toast.LENGTH_LONG).show();
                    }
                });

                dref.child(userID).child("Notes").child(noteName+userID).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            System.out.println(dataSnapshot.getValue());
                            HashMap<String, Object> dataMap = (HashMap<String, Object>) dataSnapshot.getValue();
                            NewNote abs = new NewNote((String)dataMap.get("name"), (String) dataMap.get("content"));
                            System.out.println(abs.name+"        "+abs.content);

                        }
                        else{
                            System.out.println("Failed");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                System.out.println(abs);

            }
        });
    }
}
