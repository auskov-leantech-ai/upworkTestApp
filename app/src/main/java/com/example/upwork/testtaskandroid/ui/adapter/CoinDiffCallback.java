package com.example.upwork.testtaskandroid.ui.adapter;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.upwork.testtaskandroid.entity.Coin;

public class CoinDiffCallback extends DiffUtil.ItemCallback<Coin> {

    @Override
    public boolean areItemsTheSame(@NonNull Coin oldItem, @NonNull Coin newItem) {
        return oldItem.rank.equals(newItem.rank);
    }

    @SuppressLint("DiffUtilEquals")
    @Override
    public boolean areContentsTheSame(@NonNull Coin oldItem, @NonNull Coin newItem) {
        return oldItem.equals(newItem);
    }
}
