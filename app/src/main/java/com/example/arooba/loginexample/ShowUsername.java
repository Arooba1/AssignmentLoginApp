package com.example.arooba.loginexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowUsername extends AppCompatActivity {

    String getusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_username);
        setContentView(R.layout.activity_show_username);

        TextView tv=(TextView)findViewById(R.id.txtWelcome);
        SharedPreferences settings = getSharedPreferences("mypreference", Context.MODE_PRIVATE);
        getusername = settings.getString("unamepass", "");

        tv.setText(getusername);
    }
}
