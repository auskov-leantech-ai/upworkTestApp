package com.example.upwork.testtaskandroid.api.coins;

import com.example.upwork.testtaskandroid.BuildConfig;
import com.example.upwork.testtaskandroid.api.CoinRankingApiService;
import com.example.upwork.testtaskandroid.entity.Coin;
import com.example.upwork.testtaskandroid.repositiry.CoinsRepository;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class CoinsRepositoryImpl implements CoinsRepository {

    @Override
    public Single<List<Coin>> getCoins() {
        return CoinRankingApiService.api.getCoins(BuildConfig.Token)
                .map(baseCoinRankingResponse -> baseCoinRankingResponse.data.coins);
    }
}
