package com.example.gav.randomusergenerator.users;

import com.example.gav.randomusergenerator.BasePresenter;
import com.example.gav.randomusergenerator.BaseView;
import com.example.gav.randomusergenerator.api.model.ResultsItem;

import java.util.List;

import androidx.annotation.NonNull;

public interface UsersContract {
    interface View extends BaseView<Presenter> {

        void showTasks(List<ResultsItem> users);

        void showUserDetails(String userID);
    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadUsers(boolean forceUpdate);

        void openUserDetails(@NonNull ResultsItem requestedTask);
    }
}
