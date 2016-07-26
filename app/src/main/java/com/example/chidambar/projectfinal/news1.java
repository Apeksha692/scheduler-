package com.example.chidambar.projectfinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBar;

import java.util.ArrayList;
import java.util.List;



public class news1 extends AppCompatActivity {

    ListView lvCallList;
    ProgressDialog pd;
    ArrayList<String> aa1 = new ArrayList<String>();
    ArrayList<String> number1= new ArrayList<String>();
    ArrayList<String> sle=new ArrayList<String>();
    int count=0;
    int sel_num1[];
    Contact cnt[];
    Button b1;
    int count1=0;
    DBHelper db;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news1);

        db=new DBHelper(getApplicationContext());
        ActionBar actionBar = getSupportActionBar();
        // actionBar.setLogo(R.mipmap.ic_launcher);
        //actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("CONTACTS");
        //db.dropcontact();


        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f970d70f")));


        lvCallList = (ListView) findViewById(R.id.list);
        b1=(Button)findViewById(R.id.btn);


        new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected void onPreExecute()
            {
                pd = ProgressDialog.show(news1.this,
                        "Loading..", "Please Wait", true, false);
            }// End of onPreExecute method

            @Override
            protected Void doInBackground(Void... params)
            {
                getContacts();

                return null;
            }// End of doInBackground method

            @Override
            protected void onPostExecute(Void result)
            {
                pd.dismiss();
                CustomAdapter cus = new CustomAdapter(news1.this);
                // ArrayAdapter<String>   arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,aa);
                lvCallList.setAdapter(cus);

            }//End of onPostExecute method
        }.execute((Void[]) null);
    }
    private void getContacts()
    {
        //db=openOrCreateDatabase("MYDB",MODE_PRIVATE,null);
        //db.execSQL("create table if not exists MYCONTACT(name varchar,no varchar)");
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null,null, null, ContactsContract.Contacts.SORT_KEY_PRIMARY +" ASC");
        if (cur.getCount() > 0)
        {
            while (cur.moveToNext())
            {
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                aa1.add(name);
                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                {
                    Cursor pCur = cr.query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
                            new String[]{id},
                            null);

                    while (pCur.moveToNext())
                    {
                        String phoneNumber = pCur.getString(pCur.getColumnIndex( ContactsContract.CommonDataKinds.Phone.NUMBER));
                        number1.add(phoneNumber);
                    }

                    pCur.close();

                }
            }
            b1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String num=new String("");
                    int j=0;
                   // db.onUpgrade(db,0,0);

                    for(int i=0;i<number1.size();i++)
                    {
                        try {
                            if (sel_num1[i] == 1) {
                                Log.d("Sel", "Num:" + number1.get(i) + " ," + "Name:" + aa1.get(i));
                                count1++;
                                num+=number1.get(i)+",";
                                cnt[j].setName(aa1.get(i));
                                cnt[j].setNumber(number1.get(i));
                                // j++;

                            }
                        }
                        catch(Exception e){
                            Log.e("error","eree"+e.getMessage());
                        }
                        //  else{

                        //Log.d("totalcount",Integer.toString(count1));


                        //}
                        // Log.i("Sel","Num:"+sel_num.get(i));

                    }

                    //Intent intent = new Intent();
                    if(count1>0)
                    {
                        Intent intent=new Intent(news1.this, news2.class);
                        intent.putExtra("contacts",num);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Please select the contacts!",Toast.LENGTH_LONG).show();

                }
            });

            sel_num1=new int[aa1.size()];

        }


    }

    public class CustomAdapter extends BaseAdapter
    {
        /*
         * Variables Declaration section
         */
        private Context mContext;

        public CustomAdapter(Context context)
        {
            mContext = context;
        }//End of CustomAdapter constructor

        public int getCount()
        {
            return aa1.size();
        }//End of getCount method

        public Object getItem(int position)
        {
            return position;
        }//End of getItem method

        public long getItemId(int position)
        {
            return position;
        }//End of getItemId method

        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder holder;
            final int pos = position;

            if (convertView == null)
            {
                holder = new ViewHolder();

                convertView = LayoutInflater.from(mContext).inflate(R.layout.display_contact, null);
                holder.textviewName = (TextView) convertView.findViewById(R.id.textView1);
                holder.textviewNumber = (TextView) convertView.findViewById(R.id.textView2);
                holder.checkbox = (CheckBox) convertView.findViewById(R.id.checkBox1);

                convertView.setTag(holder);
            }//End of if condition
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }//End of else

            holder.checkbox.setId(position);
            holder.textviewName.setId(position);
            holder.textviewNumber.setId(position);


            holder.textviewName.setText(aa1.get(position));
            holder.textviewNumber.setText("No. "+number1.get(position));

            holder.id = position;

            holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    // compoundButton.getId();
                    //System.out.println("ID:"+ compoundButton.getId());

                    if(compoundButton.isChecked())
                    {
                        sel_num1[compoundButton.getId()]=1;
                        // count++;
                    }
                    else
                        sel_num1[compoundButton.getId()] = 0;
                    // count--;

                }
            });
            return convertView;
        }//End of getView method



    }//End of CustomAdapter instance inner class

    static class ViewHolder
    {
        TextView textviewName;
        TextView textviewNumber;
        CheckBox checkbox;
        int id;
    }


}