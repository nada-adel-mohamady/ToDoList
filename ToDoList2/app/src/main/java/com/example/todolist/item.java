package com.example.todolist;

public class item {
    private  String task;

    public item(String task){
        this.task = task;

    }
    public void setTask(String task){this.task = task; }
    String getTask(){return this.task;}
}
