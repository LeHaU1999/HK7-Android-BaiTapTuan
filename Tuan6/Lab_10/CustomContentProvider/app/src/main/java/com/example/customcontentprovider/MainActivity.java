package com.example.customcontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.customcontentprovider.Providers.StudentsProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtName, txtGrade;
    Button btnAddName, btnRetriveStudent;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtGrade = findViewById(R.id.txtGrade);
        txtName = findViewById(R.id.txtName);
        listView = findViewById(R.id.listView);
    }

    public void onClickAddName(View v) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentsProvider.NAME, txtName.getText() + "");
        contentValues.put(StudentsProvider.GRADE, txtGrade.getText() + "");
        Uri uri = getContentResolver().insert(StudentsProvider.CONTENT_URI, contentValues);
        // Student student = new Student();
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetriveStudent(View view) {
//        String URL = "content://com.letranbaosuong.provider.College/students";
        String URL = StudentsProvider.URL;
        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");
        ArrayList<String> list = new ArrayList<>();
        String s = "";
        String idColumnStudent;
        String nameColumnStudent;
        String gradeColumnStudent;
        if (c.moveToFirst()) {
            do {
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                                ", " + c.getString(c.getColumnIndex(StudentsProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex(StudentsProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
                idColumnStudent = c.getString(c.getColumnIndex(StudentsProvider._ID));
                nameColumnStudent = c.getString(c.getColumnIndex(StudentsProvider.NAME));
                gradeColumnStudent = c.getString(c.getColumnIndex(StudentsProvider.GRADE));
                s += "ID: " + idColumnStudent + " - Name: " + nameColumnStudent + " - Grade: " + gradeColumnStudent;
                list.add(s);
                s = "";
            } while (c.moveToNext());
            c.close();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
        }
    }
}
