package com.example.upwork.testtaskandroid.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.upwork.testtaskandroid.entity.Coin;
import com.example.upwork.testtaskandroid.repositiry.CoinsRepository;
import com.example.upwork.testtaskandroid.ui.base.BaseViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ListCoinViewModel extends BaseViewModel {

    private final CoinsRepository coinsRepository;
    private final MutableLiveData<List<Coin>> coins = new MutableLiveData<>();

    public ListCoinViewModel(CoinsRepository repository) {
        this.coinsRepository = repository;
        fetchCoins();
    }

    private void fetchCoins() {
        this.compositeDisposable.add(coinsRepository.getCoins()
                .doOnSubscribe(disposable -> isInProgress.postValue(true))
                .doFinally(() -> isInProgress.postValue(false))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        list -> coins.postValue(list),
                        throwable -> postMessage("Error: " + throwable.getLocalizedMessage())
                )
        );
    }

    public LiveData<List<Coin>> getCoins() {
        return coins;
    }
}
