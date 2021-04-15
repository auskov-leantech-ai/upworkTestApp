package com.example.upwork.testtaskandroid.api;

import com.example.upwork.testtaskandroid.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinRankingApiService {

    public static final CoinRankingApi api = new Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build().create(CoinRankingApi.class);
}
