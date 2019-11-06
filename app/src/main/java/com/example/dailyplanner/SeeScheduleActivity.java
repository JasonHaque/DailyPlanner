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

public class SeeScheduleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ScheduleAdapter adapter;
    public static ArrayList<Task> taskArrayList;
    private DatabaseReference dref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_schedule);
        bindWidgets();
    }
    private void createlistData(){
        dref.child(userID).child("Schedule").addValueEventListener(new ValueEventListener() {
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
                        Task abs = new Task((String)userdata.get("nameTask"), (String) userdata.get("timeTask"));
                        System.out.println("3------>"+abs.nameTask + abs.timeTask);
                        taskArrayList.add(abs);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void bindWidgets(){
        recyclerView=findViewById(R.id.recyclerViewTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskArrayList = new ArrayList<>();
        adapter = new ScheduleAdapter(this,taskArrayList);
        recyclerView.setAdapter(adapter);
        dref= FirebaseDatabase.getInstance().getReference();
        createlistData();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SeeScheduleActivity.this, NotesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }
}
