package com.example.chidambar.projectfinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Chidambar on 08-11-2015.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.sql.Time;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contactdb.db";
    //public static final String CONTACT_TABLE1="create table "+final+" ("+final_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+phone +"TEXT NOT NULL, " + msg +" TEXT,"+ date+"DATE,"+time1+"TIME);";
    public static final String CONTACT_TABLE_NAME = "contacts_tbl";
    public static final String CONTACT_TABLE_NAMESPL = "spl_day";



    private HashMap hp;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 2);
        Log.e("DB", "Working");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("DB1", "Working");
        // TODO Auto-generated method stub

        db.execSQL("CREATE TABLE IF NOT EXISTS " + CONTACT_TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT,phone TEXT,msg TEXT,date1 TEXT,time1 TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + CONTACT_TABLE_NAMESPL + " (id INTEGER PRIMARY KEY AUTOINCREMENT,phone TEXT,msg TEXT,date1 TEXT,time1 TEXT)");

    }


    public boolean insertContact  (String phone, String msg)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("DB", "Working insert");
        db.execSQL("insert into contacts_tbl (phone,msg) values ('" + phone + "','" + msg + "')");
        return true;
    }


    public Cursor getAllContacts()
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        Cursor res1=  db1.rawQuery("select * from contacts_tbl", null);

        return res1;
    }
    public Cursor getfinalnum()
    {
        SQLiteDatabase dbg = this.getReadableDatabase();
        Cursor res1 =  dbg.rawQuery("select num,msg from final", null);

        return res1;
    }
    public Cursor getdatetime()
    {
        SQLiteDatabase dbd=this.getReadableDatabase();
        Cursor res2=dbd.rawQuery("select date1,time1 from final",null);
        return res2;
    }

    public Cursor getRecentMsg(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select max(id) as id from contacts_tbl", null );

        return res;

    }
    public Cursor getallModifyDetails(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from contacts_tbl where id="+id,null);
        return res;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        Log.e("DB2", "Wrking");
      //  db.execSQL("CRATE TABLE IF NOT EXISTS "+CONTACT_TABLE_NAME+" (id INTEGER PRIMARY KEY AUTOINCREMENT,phone TEXT,msg TEXT,date1 TEXT,time1 TEXT");
       // db.execSQL("DROP TABLE IF EXISTS contactsfinal");
        onCreate(db);
    }


    public  void updateSchedule(int id,String date,String time){
        SQLiteDatabase db=this.getWritableDatabase();

        db.execSQL("update contacts_tbl set date1='" + date + "',time1='" + time + "' where id=" + id + "");
    }
    public Cursor getScheduledContacts(String dates,String times){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from contacts_tbl where date1='" + dates + "' and time1='" + times + "'",null);
        return res;
    }
    public Cursor getdatadate(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from contacts_tbl order by date1 " ,null);
        return res;

    }
    public void updatedetails( int id,String str,String str2){
        SQLiteDatabase db= this.getReadableDatabase();
        Log.e("details","detls"+str+str2);
        db.execSQL("update contacts_tbl set phone='"+str+"',msg='"+str2+"' where id="+id+"");




    }

    public boolean insertspl(String phone, String msg)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("DB","Working insert spl");
        db.execSQL("insert into spl_day(phone,msg) values('" + phone + "','"+msg+"')");
        return true;
    }


    public Cursor getspl()
    {
        SQLiteDatabase db1 = this.getReadableDatabase();
        Cursor res1=  db1.rawQuery("select * from spl_day", null);

        return res1;
    }
    public  void updatesplSchedule(int id,String date){
        SQLiteDatabase db=this.getWritableDatabase();

        db.execSQL("update contacts_tbl set date1='" + date + "' where id=" + id + "");
    }







}

