package com.example.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    Intent intent;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_RelativeLayoutActivity:
                intent = new Intent(this, RelativeLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_LinearLayoutActivity_Vertical:
                intent = new Intent(this, LinearLayoutVerticalActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_LinearLayoutActivity_Horizontal:
                intent = new Intent(this, LinearLayoutHorizontalActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_TableLayoutActivity:
                intent = new Intent(this, TableLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_GridLayoutActivity:
                intent = new Intent(this, GridLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_GridLayoutActivity_Example:
                intent = new Intent(this, GridLayoutExampleActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_FrameLayoutActivity:
                intent = new Intent(this, FrameLayoutActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
