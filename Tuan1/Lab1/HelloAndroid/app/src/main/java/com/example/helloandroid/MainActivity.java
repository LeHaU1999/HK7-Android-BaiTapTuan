package com.example.helloandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MyMessage";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        // Layout (Cách bố trí các thành phần trên giao diện).
//        RelativeLayout layout = new RelativeLayout(this);
//        layout.setBackgroundColor(Color.GREEN);
//
//        // Tạo Button
//        Button button=new Button(this);
//        button.setText("My Button");
//
//        // Thêm Button vào layout
//        layout.addView(button);
//        setContentView(layout);

        setContentView(R.layout.activity_main);
        // Print Log
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Print Log
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Print Log
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Print Log
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Print Log
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Print Log
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Print Log
        Log.i(TAG, "onRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Print Log
        Log.i(TAG, "onCreateOptionsMenu");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Print Log
        Log.i(TAG, "onOptionsItemSelected");

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
