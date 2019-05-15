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

public class login extends AppCompatActivity {

    Intent  MyIntent ;
    EditText Et1;
    EditText Et2;
    private SQLiteDatabase db;
    private Cursor result;

    private Cursor iduser ;
    private static String id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        MyIntent = getIntent();
        Et1 = findViewById(R.id.inpu1);
        Et2 = findViewById(R.id.inpu2);


    }

    public static String getId() {
        return id;
    }

    public void cliqueBouton(View view) {



        String a = Et1.getText().toString();  //je convertis en String


        String b = Et2.getText().toString();


        String sql = "SELECT pass FROM Users WHERE username = '"+ b +"';";
        Log.i("db ", "cliqueBouton: " + sql);
        //StringBuilder sql = new StringBuilder();
        //sql.append("SELECT * FROM ").append("Users");
        db = openOrCreateDatabase("App.db", MODE_PRIVATE, null);
        result = db.rawQuery(sql, null);
        result.moveToFirst();



        if(result!=null && result.getCount()>0) {
            // si le résultat de la requète n'est pas nul

            String str = result.getString(result.getColumnIndex("pass"));
            // on met le mot de passe dans un string
            //Log.i("db ", "cliqueBouton: " + str); //(result.getColumnIndex("content"));
            //Log.i("db ", "cliqueBouton: " + a);
            if (str.equals(a)) {
            //si les deux mdp sont égaux

                iduser = db.rawQuery( "SELECT id FROM Users WHERE username = '"+ b +"';", null);
                iduser.moveToFirst();
                id = iduser.getString(iduser.getColumnIndex("id"));
                db.close();
                Intent  Intent3 = new Intent(login.this,connected.class);
                startActivityForResult (Intent3, 1);
                finish();
            }
            else {
                db.close();
            }

        }



        db.close();

        MyIntent.putExtra("EXTRA2", a + b);


        setResult(Activity.RESULT_OK, MyIntent);
        //finish();
    }
}
