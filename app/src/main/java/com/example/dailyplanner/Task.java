package com.example.dailyplanner;

public class Task {
    public String nameTask,timeTask;

    public Task(){

    }

    public Task(String nameTask, String timeTask) {
        this.nameTask = nameTask;
        this.timeTask = timeTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getTimeTask() {
        return timeTask;
    }

    public void setTimeTask(String timeTask) {
        this.timeTask = timeTask;
    }
}
