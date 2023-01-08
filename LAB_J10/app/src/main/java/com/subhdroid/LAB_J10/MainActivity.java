package com.subhdroid.LAB_J10;

//10. Create a fragment that has its own UI and enable your activities to communicate with
//        fragments.

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton homeBtn, reelsBtn, notificationBtn, profileBtn;
        homeBtn = findViewById(R.id.homeBtn);
        reelsBtn = findViewById(R.id.reelsBtn);
        notificationBtn = findViewById(R.id.notificationBtn);
        profileBtn = findViewById(R.id.profileBtn);

        loadFragment(new NotificationsFragment(), 0);

        homeBtn.setOnClickListener(view -> loadFragment(new HomeFragment(), 1));

        reelsBtn.setOnClickListener(view -> loadFragment(new ReelsFragment(), 1));

        notificationBtn.setOnClickListener(view -> loadFragment(new NotificationsFragment(), 1));

        profileBtn.setOnClickListener(view -> loadFragment(new ProfileFragment(), 1));
    }

    public void loadFragment(Fragment fragment, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag == 0)
            ft.add(R.id.containerFrame, fragment);
        else
            ft.replace(R.id.containerFrame, fragment);

        ft.commit();
    }
}