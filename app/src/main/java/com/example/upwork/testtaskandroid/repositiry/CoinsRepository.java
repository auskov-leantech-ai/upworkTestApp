package com.example.upwork.testtaskandroid.repositiry;

import com.example.upwork.testtaskandroid.entity.Coin;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface CoinsRepository {

    Single<List<Coin>> getCoins();
}
