package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LearnBundleActivity extends AppCompatActivity {

    EditText txta, txtb;
    Button btnketqua, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Learn Bundle");
        setContentView(R.layout.activity_learn_bundle);
        txta = findViewById(R.id.txta);
        txtb = findViewById(R.id.txtb);
        btnketqua = findViewById(R.id.btnketqua);
        btnExit = findViewById(R.id.btnExit);
        btnketqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Tạo Intent để mở ResultActivity
                    Intent myIntent = new Intent(LearnBundleActivity.this, ResultActivity.class);
                    //Khai báo Bundle
                    Bundle bundle = new Bundle();
                    int a = Integer.parseInt(txta.getText().toString());
                    int b = Integer.parseInt(txtb.getText().toString());
                    //đưa dữ liệu riêng lẻ vào Bundle
                    bundle.putInt("soa", a);
                    bundle.putInt("sob", b);
                    //Đưa Bundle vào Intent
                    myIntent.putExtra("MyPackage", bundle);
                    //Mở Activity ResultActivity
                    startActivity(myIntent);
                } catch (NumberFormatException ex) {
                    Toast.makeText(LearnBundleActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
