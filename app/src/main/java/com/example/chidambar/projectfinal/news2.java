package com.example.chidambar.projectfinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.database.Cursor;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import java.lang.String;
import java.util.*;

public class news2 extends AppCompatActivity {
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
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news2);

        String num=getIntent().getStringExtra("contacts");

        Log.e("Data",num);
        db = new DBHelper(getApplicationContext());
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        t1 = (TextView) findViewById(R.id.textView3);
        t2 = (TextView) findViewById(R.id.textView4);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        ActionBar actionBar = getSupportActionBar();
        // actionBar.setLogo(R.mipmap.ic_launcher);
        //actionBar.setDisplayUseLogoEnabled(true);
        // db1=SQLiteDatabase.openOrCreateDatabase("MYDB",null, null);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("SCHEDULE");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f970d70f")));


       e1.setText(num.substring(0, num.length() - 2));
    }


    public void clk3(View v) {

        //  Log.e("test","wrking");



          /*SmsManager smsManger = SmsManager.getDefault();
          smsManger.sendTextMessage(e1.getText().toString(), null,e2.getText().toString(), null, null);
          Toast.makeText(getApplicationContext(), "Messege snet!!", Toast.LENGTH_LONG).show();

          //startActivity(new Intent(this,));*/


        Log.i("Send SMS", "");


            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(e1.getText().toString(), null, e2.getText().toString(), null, null);
                Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "SMS faild, please try again", Toast.LENGTH_LONG).show();
                Log.i("Error", e.getMessage());
            }


    }



    public void clk4(View v) {
        String num1 = e1.getText().toString();
        String msg = e2.getText().toString();
        Cursor a ;
        //   SmsManager smsManger = SmsManager.getDefault();
        //smsManger.sendTextMessage(e1.getText().toString(), null, e2.getText().toString(), null, null);
        String str1=new String();
       // e1.setText("");
       // e2.setText("");
                    int id=0;
                   try {
                       Log.e("inserting number", "insert" + e1.getText());
                      db.insertContact(e1.getText().toString(), e2.getText().toString());

                       rs=db.getRecentMsg();

                       if (rs.moveToFirst()) {
                           try {
                               do {
                                   id= rs.getInt(0);
                               } while (rs.moveToNext());

                           } catch (Exception e) {
                               Log.i("Error", e.getMessage());
                           }
                           e1.setText(str.substring(0, str.length() - 2));

                       }
                       Log.e("error", "insetred" + msg);

                   } catch (Exception e) {
                       Log.e("error", "erinsert" + e.getMessage());
                   }

        Intent i=new Intent(this, new3.class);
        i.putExtra("id",id);
        startActivity(i);


       }





    }
    // public void clk8(View v){
    // startActivity(new Intent(news2.this,SmsClass.class));
    // }







