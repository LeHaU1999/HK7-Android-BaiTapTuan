package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    TextView txtketqua;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Result");
        setContentView(R.layout.activity_result);
        txtketqua = findViewById(R.id.txtketqua);
        btnBack = findViewById(R.id.btnBack);
        //lấy intent gọi Activity này
        Intent callerIntent = getIntent();
        //có intent rồi thì lấy Bundle dựa vào MyPackage
        Bundle packageFromCaller = callerIntent.getBundleExtra("MyPackage");
        //Có Bundle rồi thì lấy các thông số dựa vào soa, sob
        int a = packageFromCaller.getInt("soa");
        int b = packageFromCaller.getInt("sob");
        //tiến hành xử lý
        giaipt(a, b);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void giaipt(int a, int b) {
        String kq = "";
        if (a == 0 && b == 0) {
            kq = "Vô số nghiệm";
        } else if (a == 0 && b != 0) {
            kq = "Vô nghiệm";
        } else {
            DecimalFormat dcf = new DecimalFormat("0.##");
            kq = dcf.format(-b * 1.0 / a);
        }
        txtketqua.setText(kq);
    }
}
