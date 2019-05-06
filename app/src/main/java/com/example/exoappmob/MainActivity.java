package com.example.myapplication2;

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
    private static final String TABLE_NAME = "Users";
    private SQLiteDatabase db;
    private StringBuilder t_debug;


    TextView tv = null;
    TextView tv1 = null;

    String sql = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME
            + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " username TEXT ,pass TEXT, email TEXT);" ;
    //Button bouton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        //db.execSQL ("DROP TABLE Users");
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " username TEXT ,pass TEXT, email TEXT);");
        db.close();

        Log.i("db ", "cliqueBouton: " + sql);
        //t_debug.append("DB is CREATED. ").append("Path: ").append(DB_NAME).append(" Table: ").append(TABLE_NAME).append("\n");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv1);
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

    public void cliqueBouton3(View view)
    {
        tv.setText("Vous avez utilisé la méthode onClick !");

    }
    public void vue1 (View view)
    {
        Intent  Intent1 = new Intent(MainActivity.this,view1.class);
        startActivityForResult (Intent1, 1);

    }


    public void vue2 (View view){
        //tv.setText("Vous avez utilisé un listener !");
        Intent  Intent2 = new Intent(MainActivity.this,view2.class);
        startActivityForResult (Intent2,2);
    }


}