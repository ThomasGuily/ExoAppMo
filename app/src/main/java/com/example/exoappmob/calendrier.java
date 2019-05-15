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


public class calendrier extends AppCompatActivity {
    TextView tv1 = null ;
    TextView tv2 = null ;
    Integer id = Integer.parseInt(login.getId());
    String sql ="SELECT * FROM Actions WHERE id_Users = "+ id + ";";
    String howlong ="";
    String date ="";
    String actionname = "";
    Integer somme = 0 ;
    private SQLiteDatabase db;
    private Cursor result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendrier);

        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);


        db = openOrCreateDatabase("App.db", MODE_PRIVATE, null);
        result = db.rawQuery(sql, null);

        result.moveToFirst();
        howlong =  result.getString(result.getColumnIndex("howlong"));
        actionname = result.getString(result.getColumnIndex("actionname"));
        date = result.getString(result.getColumnIndex("date"));
        somme = Integer.parseInt(result.getString(result.getColumnIndex("howlong")));
        try {
            while (result.moveToNext()) {
                howlong += "__"+ result.getString(result.getColumnIndex("howlong"));
                actionname += "__"+result.getString(result.getColumnIndex("actionname"));
                date += "__"+result.getString(result.getColumnIndex("date"));
                somme += Integer.parseInt(result.getString(result.getColumnIndex("howlong")));
            }
        } finally {
            result.close();
        }

        db.close();




        tv1.setText("Nom des actions: "+ actionname+ "\nDates des actions: " + date +"\nNombre d'heures:" +howlong); //actions réalisées par la personne connectée
        tv2.setText("Somme: En tout j'ai passé " +somme+" heures sur le projet" ); //heures passée pour la personne connectée




    }


    public void cliqueBouton(View view) {
        Intent Intent1 = new Intent(calendrier.this, connected.class);
        startActivityForResult(Intent1, 1);
    }
}
