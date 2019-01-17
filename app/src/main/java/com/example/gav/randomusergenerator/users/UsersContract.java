package com.example.gav.randomusergenerator.users;

import com.example.gav.randomusergenerator.BasePresenter;
import com.example.gav.randomusergenerator.BaseView;
import com.example.gav.randomusergenerator.api.model.ResultsItem;

import java.util.List;

import androidx.annotation.NonNull;

public interface UsersContract {
    interface View extends BaseView<Presenter> {

        void showUsers(List<ResultsItem> users);

        void showUserDetails(String userID);
    }

    interface Presenter extends BasePresenter {

        void loadUsers(int count);

        void openUserDetails(@NonNull ResultsItem requestedTask);
    }
}
