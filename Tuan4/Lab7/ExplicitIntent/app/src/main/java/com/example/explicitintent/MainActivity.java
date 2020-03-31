package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnOpenChildActivity, btnLearnBundle, btnIntentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenChildActivity = findViewById(R.id.btnOpenChildActivity);
        btnLearnBundle = findViewById(R.id.btnLearnBundle);
        btnIntentResult = findViewById(R.id.btnIntentResult);
        btnOpenChildActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenChildActivity();
            }
        });
        btnLearnBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenLearnBundle();
            }
        });
        btnIntentResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenIntentResult();
            }
        });
    }

    private void doOpenIntentResult() {
        Intent intent = new Intent(this, IntentResultActivity.class);
        startActivity(intent);
    }

    private void doOpenLearnBundle() {
        Intent intent = new Intent(this, LearnBundleActivity.class);
        startActivity(intent);
    }

    private void doOpenChildActivity() {
        Intent myIntent = new Intent(this, ChildActivity.class);
        startActivity(myIntent);
    }
}
