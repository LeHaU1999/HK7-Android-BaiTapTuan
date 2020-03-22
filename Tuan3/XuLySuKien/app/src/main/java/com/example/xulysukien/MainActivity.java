package com.example.xulysukien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xulysukien.fragment.ActivityIsListenerFragment;
import com.example.xulysukien.fragment.ExplicitListenerClassFragment;
import com.example.xulysukien.fragment.InlineAnonymousListenerFragment;
import com.example.xulysukien.fragment.ListenerInVariableFragment;
import com.example.xulysukien.fragment.OnclickFragment;
import com.example.xulysukien.fragment.ViewSubclassingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {
    /**
     * add ---implementation 'com.google.android.material:material:1.2.0-alpha05'--- into build.gradle (app)
     */

    BottomNavigationView topNavigation;
    BottomNavigationView bottomNavigation;

    TextView txtkq;
    EditText editsoa;
    EditText editsob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topNavigation = findViewById(R.id.top_navigation);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        topNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(OnclickFragment.newInstance("", ""));
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Onclick:
                    openFragment(OnclickFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_Inline_anonymous_listener:
                    openFragment(InlineAnonymousListenerFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_Activity_is_listener:
                    openFragment(ActivityIsListenerFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_Listener_in_variable:
                    openFragment(ListenerInVariableFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_Explicit_listener_class:
                    openFragment(ExplicitListenerClassFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_View_Subclassing:
                    openFragment(ViewSubclassingFragment.newInstance("", ""));
                    return true;
            }
            return false;
        }
    };

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void tinh_tong2so(View v) {
        txtkq = findViewById(R.id.txtkq);
        editsoa = findViewById(R.id.editsoa);
        editsob = findViewById(R.id.editsob);
        if (editsoa.getText().toString().trim().length() > 0 && editsob.getText().toString().trim().length() > 0) {
            int a = Integer.parseInt(editsoa.getText().toString().trim() + "");
            int b = Integer.parseInt(editsob.getText().toString().trim() + "");
            txtkq.setText((a + b) + "");
        } else {
            Toast.makeText(this, "Nhập đầy đủ giá trị!", Toast.LENGTH_SHORT).show();
        }
    }
}
