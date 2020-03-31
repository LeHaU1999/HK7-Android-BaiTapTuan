package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1. Khởi tạo dữ liệu cho mảng arr (còn gọi là data source)
        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};
        //2. Lấy đối tượng Listview dựa vào id
        ListView lv = findViewById(R.id.lvperson);
        //3. Gán Data source vào ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        //4. Đưa Data source vào ListView
        lv.setAdapter(adapter);
        final TextView txt = findViewById(R.id.txtselection);
        //5. Thiết lập sự kiện cho Listview, khi chọn phần tử nào thì hiển thị lên TextView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt.setText("position :" + position + " ; value =" + arr[position]);
            }
        });
    }
}
