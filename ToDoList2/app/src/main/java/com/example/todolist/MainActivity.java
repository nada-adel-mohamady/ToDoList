package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.todolist.R.*;


public class MainActivity extends AppCompatActivity {
ArrayList<String> todoList;
ListView listView ;
customAdpater ArrayAdapter;
boolean isImportant;
ArrayList<String>colors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layout.activity_main);
        Toolbar toolbar =  findViewById(id.toolbar);

        todoList = new ArrayList<>();
        colors = new ArrayList<String>();
        todoList.add("task1");
        colors.add("#248016");
        todoList.add("task2");
        colors.add("#248016");
        todoList.add("task3");
        colors.add("#248016");
        todoList.add("task3");
        colors.add("#248016");
        todoList.add("task3");
        colors.add("#248016");
        todoList.add("task3");
        colors.add("#248016");
        todoList.add("task3");
        colors.add("#248016");



        ArrayAdapter = new customAdpater(this,todoList,colors);
        listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(ArrayAdapter);

//------------here is a click item listener ---------------
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                // ------------HERE---put your logic you want to show when you click on the item ------
                final AlertDialog.Builder mBilder2 = new AlertDialog.Builder(MainActivity.this);
                final View mView2 = getLayoutInflater().inflate(layout.choos_option, null);
                TextView edit = (TextView) mView2.findViewById(R.id.edit);
                TextView delete = (TextView) mView2.findViewById(R.id.delete);

                mBilder2.setView(mView2);
                final AlertDialog dialogCreater2 = mBilder2.create();
                dialogCreater2.show();

                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final AlertDialog.Builder mBilder = new AlertDialog.Builder(MainActivity.this);
                        final View mView = getLayoutInflater().inflate(layout.custom_dialog, null);

                        Button cancleBtn = (Button) mView.findViewById(R.id.cancleBtn);
                        Button commitBtn = (Button) mView.findViewById(R.id.commitBtn);

                        final CheckBox important = (CheckBox) mView.findViewById(R.id.important);
                        final EditText multiLineText = (EditText) mView.findViewById(R.id.editText2);
                        TextView title = (TextView) mView.findViewById(R.id.newReminder);
                        ConstraintLayout container = (ConstraintLayout) mView.findViewById(R.id.container);
                        title.setText("Edit Reminder");
                        multiLineText.setText(todoList.get(position));
                        //----- if task is important --enforce the checkbox
                        if(colors.get(position)=="#e01616"){
                            important.setChecked(true);
                        }

                        container.setBackgroundColor(Color.rgb(0,0,255));

                        mBilder.setView(mView);
                        final AlertDialog dialogCreater = mBilder.create();
                        dialogCreater.show();
                        dialogCreater2.dismiss();

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


                                if(important.isChecked()) {
                                    Toast.makeText(MainActivity.this, "edited with important", Toast.LENGTH_SHORT).show();

                                   colors.set(position,"#e01616");

                                }
                                else {
                                    Toast.makeText(MainActivity.this, "edited", Toast.LENGTH_SHORT).show();
                                    colors.set(position,"#248016");
                                }
                                // set new reminder
                                todoList.set(position,multiLineText.getText().toString());

                                ArrayAdapter.notifyDataSetChanged();
                                dialogCreater.dismiss();
                            }
                        });
                    }

                });

                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogCreater2.dismiss();
                        todoList.remove(position);
                        colors.remove(position);
                        ArrayAdapter.notifyDataSetChanged();
                    }

                    });
            }
        });

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
                final CheckBox important = (CheckBox) mView.findViewById(id.important);
                final EditText multiLineText = (EditText) mView.findViewById(id.editText2);

                mBilder.setView(mView);
                final AlertDialog dialogCreater = mBilder.create();
                dialogCreater.show();

                isImportant = important.isChecked();
                //--just for testing
                if(important.isChecked()){

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
                        String rem = multiLineText.getText().toString();
                        todoList.add(rem);
                        if(important.isChecked()){
                            colors.add("#e01616");
                        }
                        else{
                            colors.add("#248016");
                        }
                        ArrayAdapter.notifyDataSetChanged();
                        dialogCreater.dismiss();
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


