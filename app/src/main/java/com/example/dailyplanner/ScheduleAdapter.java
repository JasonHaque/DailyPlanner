package com.example.dailyplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder> {
    private TextView nameTask,ContentTask;
    private Context context;
    private ArrayList<Task> tasks;

    public ScheduleAdapter(Context context, ArrayList<Task> planets) {
        this.context = context;
        this.tasks = planets;
    }

    @NonNull
    @Override
    public ScheduleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tasks, parent, false);
        return new ScheduleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleHolder holder, int position) {
        Task newTask =tasks.get(position);
        holder.setDetails(newTask);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class ScheduleHolder extends RecyclerView.ViewHolder{
        public ScheduleHolder(View itemView){
            super(itemView);
            nameTask=itemView.findViewById(R.id.recycler_task_name);
            ContentTask=itemView.findViewById(R.id.recycler_task_content);
        }
        public void setDetails(Task task) {

            nameTask.setText(task.getNameTask());
            ContentTask.setText(task.getTimeTask());

        }


    }
}
