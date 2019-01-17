package com.example.gav.randomusergenerator.users;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.gav.randomusergenerator.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class UsersActivity extends AppCompatActivity {
    private Toolbar appToolbar;
    private FrameLayout flRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        initViews();

        setSupportActionBar(appToolbar);

        if (savedInstanceState == null) {
            addUsersFragment();
        }
    }

    private void initViews() {
        appToolbar = findViewById(R.id.appToolbar);
        flRoot = findViewById(R.id.flRoot);
    }

    private void addUsersFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flRoot, UsersFragment.newInstance(), UsersFragment.TAG)
                .commit();
    }


}
