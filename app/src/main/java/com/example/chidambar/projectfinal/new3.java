package com.example.chidambar.projectfinal;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.content.Intent;
import android.widget.Toast;
import android.content.DialogInterface.OnClickListener;
import java.util.Calendar;
import android.app.PendingIntent;
import android.app.AlarmManager;
import android.util.Log;
import android.view.MenuInflater;
import java.util.Date;
public class new3 extends AppCompatActivity {

    private static int RQS_1 = 1;
    TimePicker tp;
    DatePicker dp;
    Button buttonA;
    TextView t1;
    DBHelper db;
    String t=new String();
    //SQLiteDatabase db1;
    // Cursor c;
    int a,b,d,e,f;
    int id=0;
    boolean flag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new3);
        db=new DBHelper(getApplicationContext());

        id=getIntent().getIntExtra("id",0);
        Log.e("id",id+"");
        // db1=SQLiteDatabase.openOrCreateDatabase("MYDB",null, null);
        //setContentView(R.layout.activity_alarm_receiver);
        ActionBar actionBar = getSupportActionBar();
        // actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("SCHEDULE");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f970d70f")));
        dp = (DatePicker) findViewById(R.id.datePicker);
        tp = (TimePicker) findViewById(R.id.timePicker3);
       // buttonA = (Button) findViewById(R.id.button3);
        //t1 = (TextView) findViewById(R.id.textView6);
        Calendar now = Calendar.getInstance();


        dp.init(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                null);


        tp.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        tp.setCurrentMinute(now.get(Calendar.MINUTE));
        // db.deleteAll();


        t=tp.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       // boolean flag;
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.image) {
            clk();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



   public void clk() {



           Calendar current = Calendar.getInstance();

           Calendar cal = Calendar.getInstance();

           cal.set(a = dp.getYear(),
                   b = dp.getMonth(),
                   d = dp.getDayOfMonth(),
                   e = tp.getCurrentHour(),
                   f = tp.getCurrentMinute(),
                   00);


           Log.e("date", "date" + d);

           //db.updateScheduleDate();
           if (cal.compareTo(current) <= 0) {
               //The set Date/Time already passed
               Toast.makeText(getApplicationContext(), "Invalid Date/Time", Toast.LENGTH_LONG).show();
           } else {
               db.updateSchedule(id, a + "-" + b + "-" + d, e + ":" + f);
               // db1.execSQL("inesrt into cactsfinal(date,time) values(" dp.getYear()-dp.getMonth()-dp.getDayOfMonth(),tp.getCurrentHour();tp.getCurrentMinute()")");
               setAlarm(cal);
               Cursor rs = db.getAllContacts();
               String str = new String("\n");
               if (rs.moveToFirst()) {
                   try {
                       do {
                           str += rs.getString(0) + " " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "\n";
                       } while (rs.moveToNext());

                   } catch (Exception e) {
                       Log.i("Error", e.getMessage());
                   }

                   Log.e("ContactsData", str);
               } else {
                   Toast.makeText(getApplicationContext(), "No emergency contacts!!!.", Toast.LENGTH_LONG).show();
               }
           }
       }




    private void setAlarm(Calendar targetCal){

        //setContentView(R.layout.time);
        Log.e("error", "er");

        //t1.setText("Alarm is set@ " + targetCal.getTime());
        Toast.makeText(this,"Alarm is set @"+targetCal.getTime(),Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getBaseContext(), alarmReceiver.class);
        intent.putExtra("timesnow",t);
        Log.d("time", t);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(new3.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);

        //Toast.makeText(new3.this, "Start Alarm with \n", Toast.LENGTH_LONG).show();
                        /*"smsNumber = " + e1.getText().toString() +
                        "\n" + "smsText = " + e2.getText().toString() + "\nScheduled for :"
                        + Hour +" "+Minute,
                Toast.LENGTH_LONG).show();*/





    } }











