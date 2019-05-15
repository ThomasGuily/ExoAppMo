package com.example.exoappmob;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.exoappmob.login;

public class ajouter extends AppCompatActivity {
    Intent  MyIntent;
    EditText Et1;
    EditText Et2;
    EditText Et3;
    private SQLiteDatabase db;
    //Integer id = Integer.parseInt(login.str1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter);

        MyIntent = getIntent();
        Et1 = findViewById(R.id.inp1);
        Et2 = findViewById(R.id.inp2);
        Et3 = findViewById(R.id.inp3);


        //tv = (TextView) findViewById(R.id.textView4);
    }

    public void cliqueBouton(View view) {




        String a = Et1.getText().toString();  //je convertis en String
        String b = Et2.getText().toString();
        String c = Et3.getText().toString();



        String sql = "INSERT INTO Actions (date, howlong, actionname) VALUES ('" + a +"','" + b +"','" + c + "')";//"," + id + ")";
        Log.i("db ", "cliqueBouton: " + sql);
        //StringBuilder sql = new StringBuilder();
        //sql.append("SELECT * FROM ").append("Users");
        db = openOrCreateDatabase("App.db", MODE_PRIVATE, null);
        db.execSQL(sql);
        db.close();



        Intent  Intent1 = new Intent(ajouter.this,connected.class);
        startActivityForResult (Intent1, 1);

        finish();


    }
}

