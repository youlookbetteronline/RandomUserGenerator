package com.example.gav.randomusergenerator.profile;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.gav.randomusergenerator.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileFragment extends Fragment {
    public static final String TAG = "ProfileFragment";
    private String imageURL, phone, email, gender, firstName, lastName, dob;
    private int age;

    private ImageView ivPhotoProfile;
    private TextView tvNameProfile, tvAgeProfile, tvPhoneProfile, tvEmailProfile, tvDobProfile, tvGenderProfile;
    private LinearLayout llPhone;

    public static ProfileFragment newInstance(String imageURL, int age, String phone, String email, String gender, String firstName, String lastName, String dob) {
        ProfileFragment fragment = new ProfileFragment();
        fragment.imageURL = imageURL;
        fragment.age = age;
        fragment.phone = phone;
        fragment.email = email;
        fragment.gender = gender;
        fragment.firstName = firstName;
        fragment.lastName = lastName;
        fragment.dob = dob;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initViews(view);
        fillData();
        initClickListener();
        return view;
    }

    private void initViews(View view) {
        ivPhotoProfile = view.findViewById(R.id.ivPhotoProfile);
        tvNameProfile = view.findViewById(R.id.tvNameProfile);
        tvAgeProfile = view.findViewById(R.id.tvAgeProfile);
        tvPhoneProfile = view.findViewById(R.id.tvPhoneProfile);
        tvEmailProfile = view.findViewById(R.id.tvEmailProfile);
        tvDobProfile = view.findViewById(R.id.tvDobProfile);
        tvGenderProfile = view.findViewById(R.id.tvGenderProfile);
        llPhone = view.findViewById(R.id.llPhone);
    }

    private void fillData() {

        Glide.with(ivPhotoProfile)
                .load(imageURL)
                .apply(RequestOptions.circleCropTransform())
                .into(ivPhotoProfile);

        String name = firstName.substring(0, 1).toUpperCase() + firstName.substring(1)
                + " " + lastName.substring(0, 1).toUpperCase() + lastName.substring(1) ;
        tvNameProfile.setText(name);

        String ageText = age + " " + getActivity().getResources().getString(R.string.years_old);
        tvAgeProfile.setText(ageText);

        tvPhoneProfile.setText(phone);

        tvEmailProfile.setText(email);

        tvGenderProfile.setText(gender);

        dob = dob.split("T")[0];
        tvDobProfile.setText(dob);
    }

    private void initClickListener() {
        llPhone.setOnClickListener(v -> {
            try
            {
                if(Build.VERSION.SDK_INT > 22)
                {
                    FragmentActivity fragmentActivity = getActivity();
                    if (fragmentActivity != null) {
                        if (ActivityCompat.checkSelfPermission(fragmentActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                            ActivityCompat.requestPermissions(fragmentActivity, new String[]{Manifest.permission.CALL_PHONE}, 101);

                            return;
                        }

                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + phone));
                        startActivity(callIntent);
                    }
                }
                else {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phone));
                    startActivity(callIntent);
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });
    }

}
