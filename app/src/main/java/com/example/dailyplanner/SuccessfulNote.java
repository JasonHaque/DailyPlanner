package com.example.dailyplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.dailyplanner.LogInActivity.userID;

import static com.example.dailyplanner.NewNoteAcitivity.sendNoteName;

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
        //dref=FirebaseDatabase.getInstance().getReference().child(userID).child(sendNoteName+userID);
    }

    private void bindListeners(){

    }
}
