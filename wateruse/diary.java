package com.example.user.wateruse;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gmlron001 on 2018/08/15.
 */

public class diary extends AppCompatActivity {
    TextView b;
    TextView l;
    TextView c;
    TextView d;
    TextView  t;
    TextView D;
    TextView C;
    TextView h;
    TextView T;
    TextView day;
    String date ;
    database myDb;
    int position;
    Cursor res;
    Button btn;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
        myDb = new database(this);
        b= (TextView) findViewById(R.id.b);
        l= (TextView) findViewById(R.id.l);
        c= (TextView) findViewById(R.id.c);
        C= (TextView) findViewById(R.id.C);
        t= (TextView) findViewById(R.id.t);
        d= (TextView) findViewById(R.id.d);
        D= (TextView) findViewById(R.id.D);
        h= (TextView) findViewById(R.id.h);
        T= (TextView)findViewById(R.id.T);
        day=(TextView) findViewById(R.id.date) ;
        Bundle extras = getIntent().getExtras();
        date= extras.getString("date");
        position=extras.getInt("pos");
        res = myDb.getData(date);
        btn = (Button) findViewById(R.id.forward);
        bt = (Button) findViewById(R.id.back);
        String da=res.getString(0).substring(0,4)+"-"+res.getString(0).substring(4,6)+"-"+res.getString(0).substring(6,8);
        day.setText(da);
        String f=res.getString(1);
        b.setText(f);
        l.setText(res.getString(2));
        c.setText(res.getString(3));
        d.setText(res.getString(4));
        t.setText(res.getString(5));
        D.setText(res.getString(6));
        h.setText(res.getString(7));
        C.setText(res.getString(8));
        T.setText(res.getString(9));






           
           

    }
    public void next(View e){

       if(position+1<calculator.dates.size()){
        entry ent=calculator.dates.get(++position);
        String item =ent.getDate();
        Intent diary=new Intent(diary.this,diary.class);
        diary.putExtra("date",item);
        diary.putExtra("pos",position);
        startActivity(diary);
         if(position==calculator.dates.size()-1)
             btn.setEnabled(false);
         finish();
       }




    }
    public void home(View e){
        Intent calc=new Intent(diary.this,MainActivity.class);
        startActivity(calc);
        finish();
    }
    public void CALC(View e){
        Intent calc=new Intent(diary.this,calculator.class);
        startActivity(calc);
        finish();
    }
    public void back(View e){
      if(position-1>=0){
        entry ent=calculator.dates.get(--position);
        String item =ent.getDate();
        Intent diary=new Intent(diary.this,diary.class);
        diary.putExtra("date",item);
        diary.putExtra("pos",position);
        startActivity(diary);
        if(position==0)
              bt.setEnabled(false);
        finish();
      }




    }

}
