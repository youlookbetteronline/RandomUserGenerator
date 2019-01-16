package com.example.gav.randomusergenerator.api;

import com.example.gav.randomusergenerator.api.model.RandomUserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomUserApi {

    @GET("api/")
    Observable<RandomUserResponse> getRandomUsers(
            @Query("results") int results
    );


}
