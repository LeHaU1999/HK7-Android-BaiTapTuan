package com.example.androidbasic2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Example1Activity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        Intent intent = getIntent();

        String value1 = intent.getStringExtra("text1");
        String value2 = intent.getStringExtra("text2");

        final TextView text1 = findViewById(R.id.my_text1);
        final TextView text2 = findViewById(R.id.my_text2);

        text1.setText(value1);
        text2.setText(value2);

        Button button = findViewById(R.id.my_button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("You click button");
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                text2.setText("You long click button");
                return true;
            }
        });
    }
}
