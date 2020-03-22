package com.example.toastnotificationalertdialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.toastnotificationalertdialog.fragments.AlertDialogFragment;
import com.example.toastnotificationalertdialog.fragments.ToastNotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    /**
     * add ---implementation 'com.google.android.material:material:1.2.0-alpha05'--- into build.gradle (app)
     */

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(ToastNotificationFragment.newInstance("", ""));
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_toast:
                    openFragment(ToastNotificationFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_alert_dialog:
                    openFragment(AlertDialogFragment.newInstance("", ""));
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
}
