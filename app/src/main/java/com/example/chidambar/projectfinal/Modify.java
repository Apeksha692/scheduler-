package com.example.chidambar.projectfinal;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import  android.view.View;
import android.util.Log;
public class Modify extends AppCompatActivity {
   DBHelper db1;
    String  id= new String();
    String  str=new String();
    String  str2=new String();
    String  str3=new String();

    Cursor a;
    EditText e1,e2,e3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        e1=(EditText)findViewById(R.id.editText4);
        e2=(EditText)findViewById(R.id.editText5);

        b1=(Button)findViewById(R.id.button4);
        ActionBar actionBar = getSupportActionBar();
        // actionBar.setLogo(R.mipmap.ic_launcher);
        //actionBar.setDisplayUseLogoEnabled(true);
        // db1=SQLiteDatabase.openOrCreateDatabase("MYDB",null, null);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("SCHEDULE");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f970d70f")));

        db1=new DBHelper(getApplicationContext());
        Intent in= new Intent();

         id=getIntent().getStringExtra("id");
        a=db1.getallModifyDetails(Integer.parseInt(id));
        if(a.moveToFirst()){
            do{
                str=a.getString(1);
                str2=a.getString(2);
               // str3=a.getString(0);
            }while(a.moveToNext());
        }
        e1.setText(str);
        e2.setText(str2);

    }
    public void clk(View v){


        db1.updatedetails(Integer.parseInt(id), e1.getText().toString(), e2.getText().toString());
        Log.e("updtes", "update" + str + str2);
        Intent in=new Intent(Modify.this,new3.class);
        in.putExtra("id",Integer.parseInt(id));
        startActivity(in);




    }



}
