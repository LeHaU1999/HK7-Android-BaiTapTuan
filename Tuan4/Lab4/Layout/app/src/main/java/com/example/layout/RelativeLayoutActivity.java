package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RelativeLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        getSupportActionBar().setTitle("Relative Layout");
    }

    public void doSave(View view) {
        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }
}
