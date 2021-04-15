package com.example.upwork.testtaskandroid.api;

import com.example.upwork.testtaskandroid.api.response.BaseCoinRankingResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface CoinRankingApi {

    @GET("coins")
    Single<BaseCoinRankingResponse> getCoins(@Header("X-Access-Token") String token);
}
