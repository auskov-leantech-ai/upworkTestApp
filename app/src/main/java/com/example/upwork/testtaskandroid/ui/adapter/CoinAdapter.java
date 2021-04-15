package com.example.upwork.testtaskandroid.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.upwork.testtaskandroid.R;
import com.example.upwork.testtaskandroid.entity.Coin;

public class CoinAdapter extends ListAdapter<Coin, CoinViewHolder> {

    public CoinAdapter(@NonNull DiffUtil.ItemCallback<Coin> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(viewType, parent, false);
        return new CoinViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {
        if (position != 0) {
            Coin currentCoin = getCurrentList().get(position - 1);
            holder.bindCoin(currentCoin);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return R.layout.item_cryptocurrency;
        } else {
            return R.layout.item_coin;
        }
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size() + 1;
    }
}

