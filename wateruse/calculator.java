package com.example.user.wateruse;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gmlron001 on 2018/08/15.
 */

public class calculator extends AppCompatActivity {
    EditText bath;
    EditText laundry;
    EditText clean;
    EditText dish;
    EditText toilet;
    EditText drink;
    EditText cooking;
    EditText Hygn;
    TextView tot;

    int bath_num = 0;
    int laundry_num = 0;
    int clean_num = 0;
    int dish_num = 0;
    int toilet_num = 0;
    int drink_num = 0;
    int cooking_num = 0;
    int Hygn_num = 0;
    Button addData;
    EditText calender;
    database myDb;
    ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayList<Integer[]> out = new ArrayList<Integer[]>();
    static ArrayList<entry> dates=new ArrayList<entry>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview);
        myDb = new database(this);
        bath = (EditText) findViewById(R.id.bath);
        laundry = (EditText) findViewById(R.id.laundry_input);
        clean = (EditText) findViewById(R.id.clean_input);
        cooking = (EditText) findViewById(R.id.cook_input);
        toilet = (EditText) findViewById(R.id.toilet_input);
        dish = (EditText) findViewById(R.id.dish_input);
        drink = (EditText) findViewById(R.id.drink_input);
        Hygn = (EditText) findViewById(R.id.hy_input);
        tot = (TextView) findViewById(R.id.num);
        calender = (EditText) findViewById(R.id.date);
        addData = (Button) findViewById(R.id.add);


    }

    public void click(View v) {
        bath_num = num(bath);
        laundry_num = num(laundry);
        clean_num = num(clean);
        dish_num = num(dish);
        toilet_num = num(toilet);
        drink_num = num(drink);
        cooking_num = num(cooking);
        Hygn_num = num(Hygn);
        int total = bath_num + laundry_num + clean_num + dish_num + drink_num + cooking_num + Hygn_num;
        String s = "" + total;
        tot.setText(s);
        list.clear();
        list.add(bath_num);
        list.add(laundry_num);
        list.add(clean_num);
        list.add(dish_num);
        list.add(toilet_num);
        list.add(drink_num);
        list.add(cooking_num);
        list.add(Hygn_num);
        list.add(total);


    }

    public void onClick(View v) {
        String p = date(calender);
        boolean isInserted = myDb.insertData(p,list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7), list.get(8));
        if (isInserted == true) {
           String m=""+list.get(8);
           String[] sicko={p,m};
           dates.add(new entry(p,list.get(8)));
            Cursor res = myDb.getData(p);
            Toast.makeText(calculator.this, "Data Insterted", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(calculator.this, "Data not Inserted", Toast.LENGTH_LONG).show();

        }
        Intent calc=new Intent(calculator.this,MainActivity.class);
        startActivity(calc);
        finish();
    }


    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    private boolean isEmpt(EditText etText) {
        if (etText.getText().toString().trim().length() == 8)
            return false;

        return true;
    }

    private String date(EditText edit) {
        String s = "20180818";
        if (!isEmpt(edit))
            return edit.getText().toString();
        return s;
    }

    public int num(EditText edit) {
        if (!isEmpty(edit))
            return Integer.parseInt(edit.getText().toString());
        return 0;

    }


}
