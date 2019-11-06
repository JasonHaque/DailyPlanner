package com.example.dailyplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.dailyplanner.LogInActivity.userID;

public class NoteHistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    public static ArrayList<NewNote> noteArrayList;
    private DatabaseReference dref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_history);
        bindWidgets();

    }
    private void createlistData(){
        dref.child(userID).child("Notes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    HashMap<String, Object> dataMap = (HashMap<String, Object>) dataSnapshot.getValue();
                    System.out.println(dataMap);
                    for(String key : dataMap.keySet()){
                        Object data = dataMap.get(key);
                        System.out.println("1------>"+data);
                        HashMap <String ,Object> userdata = (HashMap<String, Object>) data;
                        System.out.println("2------>"+userdata);
                        NewNote abs = new NewNote((String)userdata.get("name"), (String) userdata.get("content"));
                        System.out.println("3------>"+abs.name + abs.content);
                        noteArrayList.add(abs);
                    }

                    System.out.println("All the data is here ----> \n"+noteArrayList);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        System.out.println(noteArrayList);
    }

    private void bindWidgets(){
        recyclerView=findViewById(R.id.recyclerViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteArrayList = new ArrayList<>();
        adapter = new NoteAdapter(this, noteArrayList);
        recyclerView.setAdapter(adapter);
        dref= FirebaseDatabase.getInstance().getReference();
        createlistData();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(NoteHistoryActivity.this, NotesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }
}
