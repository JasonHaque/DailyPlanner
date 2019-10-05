package com.example.dailyplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ScheduleActivity extends AppCompatActivity {

    private EditText taskName,taskTime;
    private Button setTask;
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

    }

    private void setupTask(String name,String time){

    }
}
