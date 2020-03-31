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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.todolist.R.*;
import static com.example.todolist.R.id.button2;
import static com.example.todolist.R.layout.dialog_custom;


public class MainActivity extends AppCompatActivity {

    Dialog epicDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        epicDialog = new Dialog(this);

        setContentView(layout.activity_main);
        Toolbar toolbar =  findViewById(id.toolbar);
        setSupportActionBar(toolbar);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.more_tab_menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }

        //Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case id.reminder:


                AlertDialog.Builder mBilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(layout.custom_dialog, null);
                Toast.makeText(this, "reminder selected", Toast.LENGTH_SHORT).show();

                Button cancleBtn = (Button) mView.findViewById(id.cancleBtn);
                Button commitBtn = (Button) mView.findViewById(id.commitBtn);
                CheckBox important = (CheckBox) mView.findViewById(id.important);
                EditText multiLineText = (EditText) mView.findViewById(id.editText2);

                mBilder.setView(mView);
                AlertDialog dialogCreater = mBilder.create();
                dialogCreater.show();
                return true;
            case id.exit:
            Toast.makeText(this, "exit selected", Toast.LENGTH_SHORT).show();
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
        //toast.show();

    }


