package com.example.chidambar.projectfinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.util.Log;
public class SplDay extends AppCompatActivity {

    DBHelper db;
    String a;
    EditText e1, e2;
    TextView t1, t2;
    Button b1, b2;
    //SQLiteDatabase db1;
    String str = new String();
    String num= new String();
    SQLiteDatabase db1;
    Cursor rs;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spl_day);
        db = new DBHelper(getApplicationContext());
        e1 = (EditText) findViewById(R.id.editText7);
        e2 = (EditText) findViewById(R.id.editText8);
        t1 = (TextView) findViewById(R.id.textView5);
        t2 = (TextView) findViewById(R.id.textView6);
        b1 = (Button) findViewById(R.id.button6);
        ActionBar actionBar = getSupportActionBar();
        // actionBar.setLogo(R.mipmap.ic_launcher);
        //actionBar.setDisplayUseLogoEnabled(true);
        // db1=SQLiteDatabase.openOrCreateDatabase("MYDB",null, null);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("SCHEDULE");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f970d70f")));

    }
    public void clk5(View v)
    {


        db.insertspl(e1.getText().toString(), e2.getText().toString());
        Log.e("splday","splday"+e1.getText());

        rs=db.getspl();
        if(rs.moveToFirst()){

            do{
                 id=rs.getString(0);

            }while(rs.moveToNext());
        }

        Intent in =new Intent(SplDay.this,SplDate.class);
        in.putExtra("id",id);
        startActivity(in);


    }



}
