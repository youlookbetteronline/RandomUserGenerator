package com.example.gav.randomusergenerator.repository;

import com.example.gav.randomusergenerator.api.model.RandomUserResponse;
import com.example.gav.randomusergenerator.api.model.ResultsItem;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public interface IUsersRepository {
    Observable<RandomUserResponse> getTasks();
}
