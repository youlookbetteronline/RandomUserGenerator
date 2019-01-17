package com.example.gav.randomusergenerator.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.gav.randomusergenerator.R;

public class ProfileActivity extends AppCompatActivity {

    private FrameLayout profileContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();

        if (savedInstanceState == null) {
            addProfileFragment();
        }
    }

    private void initViews() {
        profileContainer = findViewById(R.id.profileContainer);
    }

    private void addProfileFragment() {
        Intent intent = getIntent();

        String imageURL = intent.getStringExtra("imageURL");
        int age = intent.getIntExtra("age", 0);
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");
        String gender = intent.getStringExtra("gender");
        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");
        String dob = intent.getStringExtra("dob");

        ProfileFragment profileFragment = ProfileFragment.newInstance(imageURL, age, phone, email, gender, firstName, lastName, dob);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.profileContainer, profileFragment, ProfileFragment.TAG)
                .commit();
    }
}
