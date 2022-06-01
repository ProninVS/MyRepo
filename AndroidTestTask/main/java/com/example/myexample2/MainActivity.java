package com.example.myexample2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        int count = sh.getInt("count", 0);
        if (count ==  3)
        {
            Toast.makeText(this, "Некий текст", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        int count = sh.getInt("count", 0);
        Log.d("check", String.valueOf(count));
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        int count=0;
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        if (sh != null)
        {
            count = sh.getInt("count", 0);
        } else
        {
            count = 0;
        }
        assert sh != null;
        SharedPreferences.Editor myEdit = sh.edit();
        if (count < 3)
        {
            myEdit.putInt("count", ++count);
        } else
        {
            count = 0;
            myEdit.putInt("count", count);
        }
        myEdit.apply();
    }
}