package com.example.upwork.testtaskandroid.ui.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.upwork.testtaskandroid.repositiry.CoinsRepository;
import com.example.upwork.testtaskandroid.ui.viewmodel.ListCoinViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final CoinsRepository coinsRepository;

    public ViewModelFactory(CoinsRepository coinsRepository) {
        this.coinsRepository = coinsRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ListCoinViewModel.class)) {
            return (T) new ListCoinViewModel(coinsRepository);
        }
        throw new IllegalArgumentException("Unknown class");
    }
}
