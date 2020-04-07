package com.example.weatherservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean binded = false;
    private WeatherService weatherService;

    private TextView weatherText;
    private EditText locationText;

    ServiceConnection weatherServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            WeatherService.LocalWeatherBinder binder = (WeatherService.LocalWeatherBinder) service;
            weatherService = binder.getService();
            binded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            binded = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherText = findViewById(R.id.text_weather);
        locationText = findViewById(R.id.text_input_location);
    }

    // Khi Activity start.
    @Override
    protected void onStart() {
        super.onStart();
        // Tạo đối tượng Intent cho WeatherService.
        Intent intent = new Intent(this, WeatherService.class);
        // Gọi method bindService(..) để giàng buộc dịch vụ với giao diện.
        this.bindService(intent, weatherServiceConnection, Context.BIND_AUTO_CREATE);
    }

    // Khi Activity ngừng hoạt động.
    @Override
    protected void onStop() {
        super.onStop();
        if (binded) {
            // Hủy giàng buộc kết nối với dịch vụ.
            this.unbindService(weatherServiceConnection);
            binded = false;
        }
    }

    // Khi click vào Button xem thời tiết.
    public void showWeather(View v) {
        String location = locationText.getText().toString();
        String weather = this.weatherService.getWeatherToday(location);
        weatherText.setText(weather);
    }
}
