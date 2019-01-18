package com.example.gav.randomusergenerator;

import android.app.Application;
import android.content.Context;

import com.example.gav.randomusergenerator.api.RandomUserApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private RandomUserApi randomUserApi;
    public RandomUserApi getRandomUserApi() {
        if (randomUserApi == null) {

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://randomuser.me/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            randomUserApi = retrofit.create(RandomUserApi.class);
        }
        return randomUserApi;
    }

    public static App getApp(Context context) {
        return ((App) context.getApplicationContext());
    }
}
