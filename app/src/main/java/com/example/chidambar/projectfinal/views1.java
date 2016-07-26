package com.example.chidambar.projectfinal;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.util.Log;
import android.widget.Button;

import  android.util.Log;


public class views1 extends AppCompatActivity {


    ArrayList<String> listname =new ArrayList<String>();
    ArrayList<String> list_no=new ArrayList<String>();
    Context context;
    LayoutInflater inflater;
    ListView lView ;
    DBHelper db1;
    Cursor a;
    String str1=new String();
    String str2= new String();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views1);
        db1 = new DBHelper(getApplicationContext());
        a = db1.getAllContacts();
        int count1 =  a.getCount();
       Log.e("msg","msg");
        for (int i = 0; i <= count1; i++) {
            if (a.moveToFirst()) {
                do {

                    str1 = a.getString(1);
                    Log. e("msg","msg"+str1+i);
                    listname.add(i,str1);
                    str2 = a.getString(3) + a.getString(4);
                    list_no.add(i,str2);
                } while (a.moveToNext());

            }


        }
    }

/*       class Contact extends BaseAdapter
        {

            Context myContext;
            public Contact(MainActivity contactActivity) {
                // TODO Auto-generated constructor stub
                this.myContext = contactActivity;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return listname.size();
            }

            @Override
            public Object getItem(int arg0) {
                // TODO Auto-generated method stub
                return arg0;
            }

            @Override
            public long getItemId(int arg0) {
                // TODO Auto-generated method stub
                return arg0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                if (convertView == null) {

                    inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    convertView = inflater.inflate(R.layout.disply_final, null);
                    final ViewHolder viewHolder = new ViewHolder();
                    viewHolder.e1= (EditText) convertView.findViewById(R.id.edittext3);
                    viewHolder.e2 = (EditText) convertView.findViewById(R.id.edittext4);


                    convertView.setTag(viewHolder);
                }

                final ViewHolder holder = (ViewHolder) convertView.getTag();
                holder.e1.setText(list_no.get(position));
                holder.id.setText(listname.get(position));


                /*(if(holder != null)
                {
                    holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            // TODO Auto-generated method stub
                            // Here We can do our rest of stuff
                            Toast.makeText(myContext, "Selected item is :-" + buttonView.getId(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                return convertView;
            }
        }
        class ViewHolder
        {
           EditText e1,e2,e3,id;
            Button b1;


        }*/
        }









