package com.example.androidbasic2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy ra Button theo ID
        Button button1 = findViewById(R.id.go_button1);
        Button button2 = findViewById(R.id.go_button2);
        Button button3 = findViewById(R.id.go_button3);
        Button button4 = findViewById(R.id.go_button4);
        Button button5 = findViewById(R.id.go_button5);

        // Sét đặt sự kiện Click vào Button1.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent:
                // (Mang nội dung sẽ gửi tới Example1Activity).
                Intent intent = new Intent(MainActivity.this, Example1Activity.class);

                // Các tham số gắn trên Intent (Không bắt buộc).
                intent.putExtra("text1", "This is text");
                intent.putExtra("text2", "This is long text");

                // Yêu cầu chạy Example1Activity.
                MainActivity.this.startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Example2Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Example3Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Example4Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Example5Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
