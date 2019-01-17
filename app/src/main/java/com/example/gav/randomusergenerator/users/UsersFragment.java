package com.example.gav.randomusergenerator.users;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gav.randomusergenerator.R;
import com.example.gav.randomusergenerator.api.model.ResultsItem;
import com.example.gav.randomusergenerator.profile.ProfileActivity;

import java.util.Collections;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UsersFragment extends Fragment implements UsersContract.View{
    public static final String TAG = "UsersFragment";
    private UsersContract.Presenter presenter;
    private RecyclerView rvUsers;
    private UsersAdapter usersAdapter;

    public static UsersFragment newInstance() {
        UsersFragment fragment = new UsersFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        initViews(view);
        presenter.onCreate();
        presenter.loadUsers(20);
        return view;
    }

    private void initViews(View view) {
        rvUsers = view.findViewById(R.id.rvUsers);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvUsers.setLayoutManager(layoutManager);
        usersAdapter = new UsersAdapter(Collections.emptyList(), resultItem -> {
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            intent.putExtra("imageURL", resultItem.getPicture().getMedium());
            intent.putExtra("age", resultItem.getDob().getAge());
            intent.putExtra("phone", resultItem.getPhone());
            intent.putExtra("email", resultItem.getEmail());
            intent.putExtra("gender", resultItem.getGender());
            intent.putExtra("firstName", resultItem.getName().getFirst());
            intent.putExtra("lastName", resultItem.getName().getLast());
            intent.putExtra("dob", resultItem.getDob().getDate());
            startActivity(intent);
        });
        rvUsers.setAdapter(usersAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvUsers.getContext(),
                ((LinearLayoutManager) layoutManager).getOrientation());
        rvUsers.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void showUsers(List<ResultsItem> users) {
        usersAdapter.setItems(users);
    }

    @Override
    public void showUserDetails(String userID) {

    }

    @Override
    public void setPresenter(UsersContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
    }

    public interface OnUserClickListener {
        void onUserClick(ResultsItem user);
    }
}
