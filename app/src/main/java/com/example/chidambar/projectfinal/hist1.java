package com.example.chidambar.projectfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import android.view.View;


import java.util.ArrayList;

public class hist1 extends AppCompatActivity {

    DBHelper db1;
    Cursor a;
    String str =null;
    String st=new String();
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist1);
        //e1=(EditText)findViewById(R.id.editText4);
        t1 = (TextView) findViewById(R.id.textView7);
        t1.setMovementMethod(new ScrollingMovementMethod());
        t2=(TextView)findViewById(R.id.textView9);
        //lv = (ListView) findViewById(R.id.list2);
        db1 = new DBHelper(getApplicationContext());
        int b = t1.getId();
        a = db1.getdatadate();
        int i = 1;
        if (a.moveToNext()) {
            do {

                str = i +"\n"+a.getString(1) + "\n"+a.getString(2)+"\n"+a.getString(3)+" "+a.getString(4)+"\n"+"\n"+"\n"+"\n"+"\n";

               // t2.append(st);
                t1.append(str);

                i++;
                b++;

            } while (a.moveToNext());

        }

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hist1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.download) {
            clkdelete();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clkdelete()
    {
        db1.deletehist();
    }
*/

}
