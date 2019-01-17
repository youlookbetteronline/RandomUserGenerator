package com.example.gav.randomusergenerator.repository;

import com.example.gav.randomusergenerator.api.RandomUserApi;
import com.example.gav.randomusergenerator.api.model.RandomUserResponse;

import io.reactivex.Observable;

public class UsersRepository implements IUsersRepository{

    private final RandomUserApi randomUserApi;

    public UsersRepository(RandomUserApi randomUserApi) {
        this.randomUserApi = randomUserApi;
    }

    @Override
    public Observable<RandomUserResponse> getUsers(int count) {
        return randomUserApi.getRandomUsers(count);
    }
}
