package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
        Toolbar toolbar = findViewById(R.id.toobaar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.CustomToolbarStyle);
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
        taskName.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                //If the keyevent is a key-down event on the "enter" button
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //...
                    // Perform your action on key press here
                    // ...
                    return true;
                }
                return false;
            }
        });

        taskTime.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                //If the keyevent is a key-down event on the "enter" button
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //...
                    // Perform your action on key press here
                    // ...
                    return true;
                }
                return false;
            }
        });
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ScheduleActivity.this, NotesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }
}
