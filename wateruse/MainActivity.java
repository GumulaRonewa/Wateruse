package com.example.user.wateruse;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    EditText calender;
   static database myDb;

    private ListView listView;

    private adapter mAdapter;
    ListView entries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        myDb = new database(this);

        listView = (ListView) findViewById(R.id.listView);
        if(calculator.dates.isEmpty()){

        }
        else{
            mAdapter = new adapter(this,calculator.dates);
            listView.setAdapter(mAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {
                   entry ent=calculator.dates.get(position);
                    String item =ent.getDate();
                    Intent diary=new Intent(MainActivity.this,diary.class);
                    diary.putExtra("date",item);
                    diary.putExtra("pos",position);
                    startActivity(diary);

                    //Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

                }
            });


        }



    }





    public void Calculator(View v) {
        Intent calc=new Intent(MainActivity.this,calculator.class);
        startActivity(calc);

    }









}
