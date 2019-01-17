package com.example.gav.randomusergenerator.users;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.gav.randomusergenerator.App;
import com.example.gav.randomusergenerator.R;
import com.example.gav.randomusergenerator.api.RandomUserApi;
import com.example.gav.randomusergenerator.repository.UsersRepository;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class UsersActivity extends AppCompatActivity {
    private Toolbar appToolbar;
    private LinearLayout llRoot;

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
        llRoot = findViewById(R.id.llRoot);
    }

    private void addUsersFragment() {
        RandomUserApi randomUserApi = App.getApp(this).getRandomUserApi();
        UsersFragment usersFragment = UsersFragment.newInstance();
        usersFragment.setPresenter(new UsersPresenter(new UsersRepository(randomUserApi), usersFragment));
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.llRoot, usersFragment, UsersFragment.TAG)
                .commit();
    }


}
