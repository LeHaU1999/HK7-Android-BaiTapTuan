package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GridLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        getSupportActionBar().setTitle("Grid Layout Basic");
    }
}
