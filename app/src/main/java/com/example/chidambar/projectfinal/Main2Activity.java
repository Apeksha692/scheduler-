package com.example.chidambar.projectfinal;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity  {


    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1=(Button)findViewById(R.id.buttonnew);
        b2=(Button)findViewById(R.id.buttonview);
        b3=(Button)findViewById(R.id.buttonhistory);
    }
    public void clk(View v){

        startActivity(new Intent(this, news1.class));


    }

    public void clk2(View v){
        startActivity(new Intent(this, CardViewActivity.class));

    }
    public void clk3(View v){
        startActivity(new Intent(this,hist1.class));


    }

    public void clk4(View v) {
        startActivity(new Intent(this, SplDay.class));

    }





}
