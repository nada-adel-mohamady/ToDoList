package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
List<String> todoList;
ListView listView ;
ArrayAdapter<String> ArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todoList = new ArrayList<>();
        todoList.add("task1");
        todoList.add("task2");

        todoList.add("task3");
        todoList.add("task3");
        todoList.add("task3");
        todoList.add("task3");
        todoList.add("task3");
        todoList.add("task3");
        todoList.add("task3");
        todoList.add("task3");
        todoList.add("task3");todoList.add("task3");
        todoList.add("task3");
        todoList.add("task3");


        ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout,todoList);
        listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(ArrayAdapter);


        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.more_tab_menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }



}
