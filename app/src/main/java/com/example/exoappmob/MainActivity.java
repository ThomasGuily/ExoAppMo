package com.example.exoappmob;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private static final String DB_NAME = "App.db";
    private static final String USERS = "Users";
    private static final String TEAM = "Team";
    private static final String ACTIONS = "Actions";
    private SQLiteDatabase db;
    //private StringBuilder t_debug;


    TextView tv = null;
    TextView tv1 = null;

    String sql = "CREATE TABLE IF NOT EXISTS "
            + USERS
            + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " username TEXT, firstname TEXT, name TEXT, pass TEXT, email TEXT);" ;
    String sql2 = "CREATE TABLE IF NOT EXISTS "
            + ACTIONS
            + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " date DATE , howlong INT, actionname TEXT,id_Users INTEGER);" ;//Requète1, crétation des tables

    //Button bouton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        //db.execSQL ("DROP TABLE Users");
        //db.execSQL ("DROP TABLE Actions");

        db.execSQL(sql);
        db.execSQL(sql2);

        db.close();

        //Log.i("db ", "cliqueBouton: " + sql);
        //t_debug.append("DB is CREATED. ").append("Path: ").append(DB_NAME).append(" Table: ").append(TABLE_NAME).append("\n");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1 = (TextView) findViewById(R.id.tView);

        Button bt = (Button) findViewById(R.id.bt2);
        /* bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                tv.setText("Vous avez utilisé un listener !");
            }
        });*/
    }

    @Override
    public void onActivityResult(int code,int result,Intent Data){
        super.onActivityResult(code,result,Data);

        Toast.makeText(MainActivity.this,"whah",Toast.LENGTH_LONG);
        if (code == 1 && result== Activity.RESULT_OK) {
            String EXTRA1 = "EXTRA1";
            String oui = Data.getStringExtra(EXTRA1) ;
            tv1.setText(oui);
            //Toast.makeText(MainActivity.this,"whah",Toast.LENGTH_LONG);
        }
        if (code == 2 && result== Activity.RESULT_OK) {
            String EXTRA2 = "EXTRA2";
            String oui = Data.getStringExtra(EXTRA2) ;
            tv1.setText(oui);
        }

    }


    public void vue1 (View view)
    {   //view1 = new View();
        Intent  Intent1 = new Intent(MainActivity.this,create.class);
        startActivityForResult (Intent1, 1);

    }


    public void vue2 (View view){
        //tv.setText("Vous avez utilisé un listener !");
        Intent  Intent2 = new Intent(MainActivity.this,login.class);
        startActivityForResult (Intent2,2);
    }



}