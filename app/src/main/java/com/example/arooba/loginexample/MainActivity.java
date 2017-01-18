package com.example.arooba.loginexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String username, inputpassword;
    DBHelper dbHelper=new DBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    dbHelper.addData();

    }
    public void onclickEvent(View view) {
        EditText etUsername = (EditText)findViewById(R.id.usernametext);
        EditText etPassword=(EditText)findViewById(R.id.passwordtext);
        TextView lblResult = (TextView) findViewById(R.id.txtResult);
        username = etUsername.getText().toString();
        inputpassword = etPassword.getText().toString();

        SharedPreferences settings = getSharedPreferences("mypreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String password = dbHelper.LoginMethod(username);

        if (password.equals(password)) {
            Intent intent = new Intent(MainActivity.this, ShowUsername.class);


            editor.putString("unamepass", username);
            editor.commit();


            startActivity(intent);
          // lblResult.setText("Login successful.");
        } else {
            lblResult.setText("Login failed. Username and/or password doesn't match.");
        }
    }
}
