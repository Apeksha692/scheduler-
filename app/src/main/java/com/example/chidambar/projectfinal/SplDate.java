package com.example.chidambar.projectfinal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.view.View;
import java.util.Calendar;

public class SplDate extends AppCompatActivity {


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
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spl_date);
        db=new DBHelper(getApplicationContext());

        id=getIntent().getIntExtra("id",0);
            Log.e("id", id + "");
            // db1=SQLiteDatabase.openOrCreateDatabase("MYDB",null, null);
            //setContentView(R.layout.activity_alarm_receiver);
            ActionBar actionBar = getSupportActionBar();
            // actionBar.setLogo(R.mipmap.ic_launcher);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("SCHEDULE");
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f970d70f")));
            dp = (DatePicker) findViewById(R.id.datePicker2);
            b1=(Button)findViewById(R.id.button7);
            // tp=(TimePicker)findViewById(R.id.timePicker);

            // buttonA = (Button) findViewById(R.id.button3);
            //t1 = (TextView) findViewById(R.id.textView6);
            Calendar now = Calendar.getInstance();


            dp.init(
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH),
                    null);


                        // db.deleteAll();


                    }



    public void clk(View v) {



        Calendar current = Calendar.getInstance();

        Calendar cal = Calendar.getInstance();

        cal.set(a = dp.getYear(),
                b = dp.getMonth(),
                d = dp.getDayOfMonth(),
                 e=12,
                 f=00,00);


        Log.e("date", "date" + d);

        //db.updateScheduleDate();
        if (cal.compareTo(current) <= 0) {
            //The set Date/Time already passed
            Toast.makeText(getApplicationContext(), "Invalid Date/Time", Toast.LENGTH_LONG).show();
        } else {
            db.updatesplSchedule(id, a + "-" + b + "-" + d);
            // db1.execSQL("inesrt into cactsfinal(date,time) values(" dp.getYear()-dp.getMonth()-dp.getDayOfMonth(),tp.getCurrentHour();tp.getCurrentMinute()")");
            setAlarm(cal);
            Cursor rs = db.getspl();
            String str = new String("\n");
            if (rs.moveToFirst()) {
                try {
                    do {
                        str += rs.getString(0) + " " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)+ "\n";
                    } while (rs.moveToNext());

                } catch (Exception e) {
                    Log.i("Error", e.getMessage());
                }

                Log.e("ContactsData", str);
                setAlarm(cal);
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

        Intent intent = new Intent(getBaseContext(), AlarmReceiver1.class);
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





    }
    }



