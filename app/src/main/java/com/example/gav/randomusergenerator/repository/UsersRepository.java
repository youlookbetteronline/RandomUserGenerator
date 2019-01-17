package com.example.gav.randomusergenerator.repository;

import com.example.gav.randomusergenerator.api.RandomUserApi;
import com.example.gav.randomusergenerator.api.model.RandomUserResponse;
import com.example.gav.randomusergenerator.api.model.ResultsItem;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UsersRepository implements IUsersRepository{

    private final RandomUserApi randomUserApi;

    public UsersRepository(RandomUserApi randomUserApi) {
        this.randomUserApi = randomUserApi;
    }

    @Override
    public Observable<RandomUserResponse> getTasks() {
        return randomUserApi.getRandomUsers(20);
    }
}
