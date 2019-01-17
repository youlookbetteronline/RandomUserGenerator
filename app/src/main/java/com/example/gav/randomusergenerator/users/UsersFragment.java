package com.example.gav.randomusergenerator.users;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gav.randomusergenerator.R;
import com.example.gav.randomusergenerator.api.model.ResultsItem;

import java.util.List;

import androidx.fragment.app.Fragment;

public class UsersFragment extends Fragment implements UsersContract.View{
    public static final String TAG = "UsersFragment";

    public static UsersFragment newInstance() {
        UsersFragment fragment = new UsersFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        return view;
    }

    @Override
    public void showTasks(List<ResultsItem> users) {

    }

    @Override
    public void showUserDetails(String userID) {

    }

    @Override
    public void setPresenter(UsersContract.Presenter presenter) {

    }
}
