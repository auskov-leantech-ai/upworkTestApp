package com.example.upwork.testtaskandroid.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.upwork.testtaskandroid.R;
import com.example.upwork.testtaskandroid.api.coins.CoinsRepositoryImpl;
import com.example.upwork.testtaskandroid.repositiry.CoinsRepository;
import com.example.upwork.testtaskandroid.ui.adapter.CoinAdapter;
import com.example.upwork.testtaskandroid.ui.adapter.CoinDiffCallback;
import com.example.upwork.testtaskandroid.ui.base.BaseActivity;
import com.example.upwork.testtaskandroid.ui.base.ViewModelFactory;
import com.example.upwork.testtaskandroid.ui.viewmodel.ListCoinViewModel;

public class MainActivity extends BaseActivity {
    private CoinAdapter coinAdapter;

    private RecyclerView recyclerView;

    @Override
    protected void initView() {
        init();
        setupUI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutId = R.layout.activity_main;
        super.onCreate(savedInstanceState);
    }

    private void init() {
        recyclerView = findViewById(R.id.listCoins);
    }

    @Override
    protected void bindViewModel() {
        super.bindViewModel();
        ((ListCoinViewModel) viewModel).getCoins().observe(this, listResource -> {
                    recyclerView.setVisibility(View.VISIBLE);
                    coinAdapter.submitList(listResource);
                }
        );
    }

    private void setupUI() {
        coinAdapter = new CoinAdapter(new CoinDiffCallback());
        recyclerView.setAdapter(coinAdapter);
    }

    @Override
    protected void setupViewModel() {
        CoinsRepository repository = new CoinsRepositoryImpl();
        viewModel = ViewModelProviders.of(
                this,
                new ViewModelFactory(repository)
        ).get(ListCoinViewModel.class);
    }
}
