package com.example.explicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class IntentResultActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_INPUT = 113;
    public static final int RESULT_CODE_SAVE1 = 115;
    public static final int RESULT_CODE_SAVE2 = 116;
    Button btnInputData, btnBack;
    ListView lvData;
    ArrayList<Integer> arrData = new ArrayList<Integer>();
    ArrayAdapter<Integer> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Intent Result");
        setContentView(R.layout.activity_intent_result);
        btnInputData = findViewById(R.id.btnopenactivity);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnInputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mở Activity với REQUEST_CODE_INPUT
                Intent intent = new Intent(IntentResultActivity.this, InputDataActivity.class);
                //gọi startActivityForResult
                startActivityForResult(intent, REQUEST_CODE_INPUT);
            }
        });
        //đoạn code dưới này học nhiều rồi, ko nói lại
        lvData = findViewById(R.id.lvdata);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrData);
        lvData.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Kiểm tra có đúng requestCode =REQUEST_CODE_INPUT hay không
        // Vì ta có thể mở Activity với những RequestCode khác nhau
        if (requestCode == REQUEST_CODE_INPUT) {
            //Kiểm trả ResultCode trả về, cái này ở bên InputDataActivity truyền về
        }
        //có nó rồi thì xử lý trở lên thông thường
        switch (resultCode) {
            case RESULT_CODE_SAVE1:
                //giá trị từ InputDataActivity
                int v1 = data.getIntExtra("data", 0);
                arrData.add(v1 * v1);
                adapter.notifyDataSetChanged();
                break;
            case RESULT_CODE_SAVE2:
                //giá trị từ InputDataActivity
                int v2 = data.getIntExtra("data", 0);
                arrData.add(v2);
                adapter.notifyDataSetChanged();
                break;
        }
    }
}