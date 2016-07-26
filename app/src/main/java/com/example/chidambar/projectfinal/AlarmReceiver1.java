package com.example.chidambar.projectfinal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Chidambar on 14-11-2015.
 */
public class AlarmReceiver1 extends BroadcastReceiver {

    EditText e1,e2;
    String str1=new String();
    String str2= new String();



    // protected void onCreate(Bundle savedInstanceState) {
    //SQLiteDatabase db = this.getReadableDatabase();


    // a =  db.rawQuery( "select name from contacts", null );
    //  c2 =  db.rawQuery("select num from contacts", null);


    //fetch all data one by one



    // }
    @Override
    public void onReceive(Context context, Intent arg1) {
        Log.d("error", "er");
        //arg0.startActivity(arg1);

        Toast.makeText(context, "Alarm received!", Toast.LENGTH_LONG).show();
        // startActivity(new Intent(this, SmsClass.class));

        Intent intent=new Intent();
        intent.setClassName("com.example.chidambar.projectfinal", "com.example.chidambar.projectfinal.SmsClass");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //Activity context ;
        context.startActivity(intent);
        // str1=intent.getStringExtra("t");
        //  Toast.makeText(context, "Alarm received!"+str1, Toast.LENGTH_LONG).show();
        // intent.putExtra("timesnow",str1);
        // Toast.makeText(alarmReceiver.this,"times" + str1,Toast.LENGTH_LONG).show();

          /* try {
               db= SQLiteDatabase.openOrCreateDatabase("MYDB",Context.MODE_PRIVATE, null);
               c = db.rawQuery("select * contactsfinal", null);
               Log.d("select", "select");
              /* if (c.moveToFirst()) {
                   do {
                       str1 = c.getString(2);
                       Log.d("select", "select1" + str1);
                       str2 = c.getString(3);
                       Log.d("select", "select1" + str2);
                       //SmsManager smsManger = SmsManager.getDefault();
                       //smsManger.sendTextMessage(str1, null,str2, null, null);
                   } while (c.moveToNext());*/

              /* } else {
                   Log.e("error", "error");
               }*/






        //startActivity(new Intent(this, new3.class));


        //db=new DBHelper(this,getApplicationContext());*/



    }

}




