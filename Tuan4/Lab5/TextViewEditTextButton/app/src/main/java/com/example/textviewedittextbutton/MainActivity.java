package com.example.textviewedittextbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {
    EditText editTextSoa, editTextSob;
    Button btnCong, buttonTru, buttonNhan, buttonChia;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        View.OnClickListener myClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnCong:
                        Cong();
                        break;
                    case R.id.buttonTru:
                        Tru();
                        break;
                    case R.id.buttonNhan:
                        Nhan();
                        break;
                    case R.id.buttonChia:
                        Chia();
                        break;
                }
            }
        };
        btnCong.setOnClickListener(myClick);
        buttonTru.setOnClickListener(myClick);
        buttonNhan.setOnClickListener(myClick);
        buttonChia.setOnClickListener(myClick);
    }

    private void Chia() {
        String sa = editTextSoa.getText() + "";
        String sb = editTextSob.getText().toString();
        double a = Double.parseDouble(sa);
        double b = Double.parseDouble(sb);
        txtKetQua.setText(a + " / " + b + " = " + (a / b));
    }

    private void Nhan() {
        String sa = editTextSoa.getText() + "";
        String sb = editTextSob.getText().toString();
        double a = Double.parseDouble(sa);
        double b = Double.parseDouble(sb);
        txtKetQua.setText(a + " * " + b + " = " + (a * b));
    }

    private void Tru() {
        String sa = editTextSoa.getText() + "";
        String sb = editTextSob.getText().toString();
        double a = Double.parseDouble(sa);
        double b = Double.parseDouble(sb);
        txtKetQua.setText(a + " - " + b + " = " + (a - b));
    }

    private void Cong() {
        String sa = editTextSoa.getText() + "";
        String sb = editTextSob.getText().toString();
        double a = Double.parseDouble(sa);
        double b = Double.parseDouble(sb);
        txtKetQua.setText(a + " + " + b + " = " + (a + b));
    }

    private void AnhXa() {
        editTextSoa = findViewById(R.id.editTextSoa);
        editTextSob = findViewById(R.id.editTextSob);
        btnCong = findViewById(R.id.btnCong);
        buttonTru = findViewById(R.id.buttonTru);
        buttonNhan = findViewById(R.id.buttonNhan);
        buttonChia = findViewById(R.id.buttonChia);
        txtKetQua = findViewById(R.id.txtKetQua);
    }
}
