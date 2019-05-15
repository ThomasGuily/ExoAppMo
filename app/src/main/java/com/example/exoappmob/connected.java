package com.example.exoappmob;
import android.app.Activity;
import android.content.Intent;
import com.example.exoappmob.login;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class connected extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connected);





    }
    public void cliqueBouton1(View view) {
        Intent  Intent1 = new Intent(connected.this,ajouter.class);
        startActivityForResult (Intent1, 1);
    }
    public void cliqueBouton2(View view) {
        Intent  Intent2 = new Intent(connected.this,modifier.class);
        startActivityForResult (Intent2, 2);

    }
    public void cliqueBouton3(View view) {
        Intent  Intent3 = new Intent(connected.this,calendrier.class);
        startActivityForResult (Intent3, 3);

    }

}
