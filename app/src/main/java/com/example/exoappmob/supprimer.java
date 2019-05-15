package com.example.exoappmob;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class supprimer extends AppCompatActivity {
    Intent MyIntent;
    EditText Et1;

    private SQLiteDatabase db;
    //Integer id = Integer.parseInt(login.str1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supprimer);
        MyIntent = getIntent();
        Et1 = findViewById(R.id.inp1);



    }
    public void cliqueBouton(View view) {




        String a = Et1.getText().toString();  //je convertis en String


        String sqdel = "DELETE FROM Actions WHERE actionname = '" + a +"';" ; //on peut supprimer n'importe quelle tache

        Log.i("db ", "cliqueBouton: " + sqdel);
        db = openOrCreateDatabase("App.db", MODE_PRIVATE, null);
        db.execSQL(sqdel);
        db.close();

        Intent  Intent1 = new Intent(supprimer.this,connected.class);
        startActivityForResult (Intent1, 1);

        finish();


    }
}
