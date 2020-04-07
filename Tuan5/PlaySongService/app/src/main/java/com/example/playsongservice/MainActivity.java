package com.example.playsongservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method này được gọi khi người dùng Click vào nút Start.
    public void playSong(View v) {
        // Tạo ra một đối tượng Intent cho một dịch vụ (PlaySongService).
        Intent intent = new Intent(MainActivity.this, PlaySongService.class);
        // Gọi phương thức startService (Truyền vào đối tượng Intent)
        startService(intent);
    }

    // Method này được gọi khi người dùng Click vào nút Stop.
    public void stopSong(View v) {
        // Tạo ra một đối tượng Intent.
        Intent intent = new Intent(MainActivity.this, PlaySongService.class);
        stopService(intent);
    }
}
