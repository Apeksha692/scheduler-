package com.example.chidambar.projectfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;

import java.util.ArrayList;


public class CardViewActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    DBHelper db1;
    Cursor a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
       db1=new DBHelper(getApplicationContext());
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                TextView t=(TextView)v.findViewById(R.id.textView4);
                Toast.makeText(getApplicationContext(),"Item "+position+" "+t.getText().toString(),Toast.LENGTH_LONG).show();
                Log.i(LOG_TAG, " Clicked on Item " + v.toString());
                Intent in=new Intent(getApplicationContext(),Modify.class);
                in.putExtra("id",t.getText().toString());
                startActivity(in);




            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();

        a=db1.getAllContacts();
        int  index=0;
        if(a.moveToFirst()){
            do {
                DataObject obj = new DataObject(a.getString(1), a.getString(2), a.getString(3)+a.getString(4),a.getString(0));
                Log.e("db","db"+a.getString(0));
                results.add(index, obj);
                index++;
            }while(a.moveToNext());
        }
       /* for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }*/
        return results;
    }

}