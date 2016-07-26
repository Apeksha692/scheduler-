package com.example.chidambar.projectfinal;

import android.database.Cursor;
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
import android.widget.Toast;

import java.util.Calendar;


    import android.content.Context;
    import android.content.Intent;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.telephony.SmsManager;
    import android.widget.EditText;
    import android.widget.Toast;

    import java.text.SimpleDateFormat;
    import java.util.Calendar;

    public class SmsClass extends AppCompatActivity {
        // SQLiteDatabase db;
        DBHelper db1;
        //SQLiteDatabase db;
        Cursor rs,rs1;
        //String str1=new String();
        //String str2=new String();
        String a = new String();
        String b=new String();
       // EditText e1;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Log.e("ContactsData", "Working");
/*        Intent in = new Intent();
        a=in.getStringExtra("timesnow");
        Toast.makeText(getApplicationContext(),"Current Time"+a,Toast.LENGTH_LONG).show();*/
            ActionBar actionBar = getSupportActionBar();
            // actionBar.setLogo(R.mipmap.ic_launcher);
            //actionBar.setDisplayUseLogoEnabled(true);
            // db1=SQLiteDatabase.openOrCreateDatabase("MYDB",null, null);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("SCHEDULE");
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f970d70f")));

            db1=new DBHelper(getApplicationContext());

            Calendar c = Calendar.getInstance();
            int secs = c.get(Calendar.SECOND);
            int mins = c.get(Calendar.MINUTE);
            int hour1 = c.get(Calendar.HOUR);
            int date1 = c.get(Calendar.DATE);
            int mon = c.get(Calendar.MONTH);
            int year=c.get(Calendar.YEAR);
            hour1=(hour1+12)%24;

            Toast.makeText(getApplicationContext(), "date" + date1, Toast.LENGTH_LONG).show();
            // e1=(EditText)findViewById(R.id.editText3);
            //rs=db1.getfinalnum();
            //rs1=db1.getdatetime();
            String dates=new String();
            String times=new String();
            dates=year +"-"+ mon +"-"+ date1;
            times=hour1+":"+mins;
            Cursor rs=db1.getScheduledContacts(dates, times);
            Log.e("ContactsData",dates+","+times);
            Log.e("Error","num"+rs.getCount());
            if(rs.moveToFirst()){
                Log.e("ContactsData","www");
                do{
                    String numbers[]=rs.getString(1).split(",");

                    for(int i=0;i<numbers.length;i++)
                    {
                        Log.e("ContactsData",numbers[i]+" "+rs.getString(2));
                        SmsManager smsManger = SmsManager.getDefault();
                        smsManger.sendTextMessage(numbers[i], null,rs.getString(2), null, null);
                    }
                }while(rs.moveToNext());
            }
            else{
                Toast.makeText(getApplicationContext(),"Someting went wrong, messege sending failed !",Toast.LENGTH_LONG).show();
            }




        }
    }


