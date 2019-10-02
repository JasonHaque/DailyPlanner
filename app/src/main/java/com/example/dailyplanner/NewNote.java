package com.example.dailyplanner;

public class NewNote {
    public String name;
    public String content;

    public NewNote(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewNote(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
