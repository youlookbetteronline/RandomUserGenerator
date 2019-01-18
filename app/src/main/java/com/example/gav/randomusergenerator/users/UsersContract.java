package com.example.gav.randomusergenerator.users;

import com.example.gav.randomusergenerator.base.BasePresenter;
import com.example.gav.randomusergenerator.base.BaseView;
import com.example.gav.randomusergenerator.api.model.ResultsItem;

import java.util.List;


public interface UsersContract {
    interface View extends BaseView<Presenter> {

        void showUsers(List<ResultsItem> users);
        void errorShowUsers(Throwable throwable);
    }

    interface Presenter extends BasePresenter {

        void loadUsers(int count);
    }
}
