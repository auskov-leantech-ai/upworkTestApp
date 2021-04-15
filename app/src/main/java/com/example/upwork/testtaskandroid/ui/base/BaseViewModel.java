package com.example.upwork.testtaskandroid.ui.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected final MutableLiveData<String> message = new MutableLiveData<>();
    protected final MutableLiveData<Boolean> isInProgress = new MutableLiveData<>();

    protected void postMessage(String message) {
        this.message.postValue(message);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

    public LiveData<Boolean> getProgress() {
        return isInProgress;
    }

    public LiveData<String> getMessage() {
        return message;
    }
}
