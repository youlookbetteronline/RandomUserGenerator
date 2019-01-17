package com.example.gav.randomusergenerator.repository;

import com.example.gav.randomusergenerator.api.model.RandomUserResponse;

import io.reactivex.Observable;

public interface IUsersRepository {
    Observable<RandomUserResponse> getUsers(int count);
}
