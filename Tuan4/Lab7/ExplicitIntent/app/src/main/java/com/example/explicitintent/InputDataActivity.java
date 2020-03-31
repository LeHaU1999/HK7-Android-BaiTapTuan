package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputDataActivity extends AppCompatActivity {
    Button btnSave1, btnSave2;
    EditText editNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Input Data");
        setContentView(R.layout.activity_input_data);
        btnSave1 = findViewById(R.id.btnSave1);
        btnSave2 = findViewById(R.id.btnSave2);
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gửi thông điệp là lưu bình phương
                sendToMain(IntentResultActivity.RESULT_CODE_SAVE1);
            }
        });
        editNumber = findViewById(R.id.editNumber);
        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gửi thông điệp là lưu số gốc
                sendToMain(IntentResultActivity.RESULT_CODE_SAVE2);
            }
        });
    }

    private void sendToMain(int resultcode) {
        try {
            Intent intent = getIntent();
            int value = Integer.parseInt(editNumber.getText() + "");
            intent.putExtra("data", value);
            setResult(resultcode, intent);
            finish();
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Vui lòng nhập số!", Toast.LENGTH_SHORT).show();
        }
    }
}
