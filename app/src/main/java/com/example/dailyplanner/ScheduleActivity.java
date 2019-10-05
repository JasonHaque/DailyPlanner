package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.dailyplanner.LogInActivity.userID;

public class ScheduleActivity extends AppCompatActivity {

    private EditText taskName,taskTime;
    private Button setTask,bNotes;
    private DatabaseReference dref;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        bindWidgets();
        bindListeners();
    }

    private void bindWidgets(){
        taskName=findViewById(R.id.schedule_item);
        taskTime=findViewById(R.id.schedule_time);
        setTask=findViewById(R.id.set_schedule);
        bNotes=findViewById(R.id.bnotes_button);
        dref= FirebaseDatabase.getInstance().getReference();
        progressDialog=new ProgressDialog(this);
    }
    private void bindListeners(){

        setTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=taskName.getText().toString();
                String time=taskTime.getText().toString();
                if(name.isEmpty() || time.isEmpty()){
                    Toast.makeText(ScheduleActivity.this,"Fill these up properly",Toast.LENGTH_LONG).show();
                    return;
                }
                setupTask(name,time);
            }
        });
        bNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScheduleActivity.this,NotesActivity.class));
            }
        });
    }

    private void setupTask(String name,String time){
        Task newTask=new Task(name,time);
        progressDialog.setTitle("Saving");
        progressDialog.show();
        dref.child(userID).child("Schedule").child(name+time).setValue(newTask).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                progressDialog.dismiss();
                Toast.makeText(ScheduleActivity.this,"Success",Toast.LENGTH_LONG).show();
            }
        });
    }
}
