package com.example.upwork.testtaskandroid.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.upwork.testtaskandroid.R;
import com.example.upwork.testtaskandroid.entity.Coin;
import com.example.upwork.testtaskandroid.utils.ConvertCoin;
import com.robinhood.spark.SparkView;

import java.util.Locale;

public class CoinViewHolder extends RecyclerView.ViewHolder {
    private final ImageView imageIcon;
    private final TextView rank, name, symbol, marketCap, price, change;
    private final SparkView sparkView;

    public CoinViewHolder(@NonNull View itemView) {
        super(itemView);

        imageIcon = itemView.findViewById(R.id.image_view_icon);
        rank = itemView.findViewById(R.id.text_view_rank);
        name = itemView.findViewById(R.id.text_view_name);
        symbol = itemView.findViewById(R.id.text_view_symbol);
        marketCap = itemView.findViewById(R.id.text_view_marketCap);
        price = itemView.findViewById(R.id.text_view_price);
        change = itemView.findViewById(R.id.text_view_change);
        sparkView = itemView.findViewById(R.id.graph);
    }

    @SuppressLint({"SetTextI18n", "StringFormatMatches", "DefaultLocale", "ResourceAsColor"})
    public void bindCoin(Coin coin) {
        Context context = itemView.getContext();
        Resources resources = context.getResources();

        sparkView.setAdapter(new SparkLineAdapter(coin.listSparkLine));

        rank.setText(coin.rank.toString());
        name.setText(coin.name);
        symbol.setText(coin.symbol);
        marketCap.setText(resources
                .getString(R.string.main_marketCap,
                        ConvertCoin.convertСapitalization(coin.marketCap)));
        price.setText(resources
                .getString(R.string.main_price, String.format(Locale.US, "%,.2f", coin.price)));

        Glide.with(context)
                .load(coin.iconUrl)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.placeholder)
                        .dontAnimate().fitCenter())
                .into(imageIcon);

        int color = 0;
        int changeString = 0;
        if (coin.change > 0) {
            color = ContextCompat.getColor(context, R.color.green);
            changeString = R.string.change_positive;
        } else {
            color = ContextCompat.getColor(context, R.color.red);
            changeString = R.string.change_negative;
        }
        change.setText(resources.getString(changeString, coin.change));
        change.setTextColor(color);
        sparkView.setLineColor(color);
    }
}
