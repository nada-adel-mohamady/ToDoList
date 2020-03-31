package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.todolist.R.*;
import static com.example.todolist.R.id.button2;
import static com.example.todolist.R.layout.dialog_custom;


public class MainActivity extends AppCompatActivity {
List<String> todoList;
ListView listView ;
ArrayAdapter<String> ArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layout.activity_main);
        Toolbar toolbar =  findViewById(id.toolbar);

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
        todoList.add("task3");
        todoList.add("task3");
        todoList.add("task3");


        ArrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout,todoList);
        listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(ArrayAdapter);


        setSupportActionBar(toolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.more_tab_menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case id.reminder:


                final AlertDialog.Builder mBilder = new AlertDialog.Builder(MainActivity.this);
                final View mView = getLayoutInflater().inflate(layout.custom_dialog, null);

                Button cancleBtn = (Button) mView.findViewById(id.cancleBtn);
                Button commitBtn = (Button) mView.findViewById(id.commitBtn);
                CheckBox important = (CheckBox) mView.findViewById(id.important);
                EditText multiLineText = (EditText) mView.findViewById(id.editText2);

                mBilder.setView(mView);
                final AlertDialog dialogCreater = mBilder.create();
                dialogCreater.show();

                boolean isImportant = important.isChecked();
                //--just for testing
                if(isImportant){
                    Toast.makeText(MainActivity.this, "checkbox checked", Toast.LENGTH_SHORT).show();
                }

                cancleBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogCreater.dismiss();
                        Toast.makeText(MainActivity.this, "canceled", Toast.LENGTH_SHORT).show();
                    }
                });

                commitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "new reminder added", Toast.LENGTH_SHORT).show();
                        // set new reminder
                    }
                });

                return true;

            case id.exit:
                Toast.makeText(this, "exit selected", Toast.LENGTH_SHORT).show();
                finish();
                System.exit(0);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }




    }


