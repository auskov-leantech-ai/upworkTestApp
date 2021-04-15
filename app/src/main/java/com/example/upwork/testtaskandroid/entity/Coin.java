package com.example.upwork.testtaskandroid.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Coin {

    @SerializedName("rank")
    public Integer rank;

    @SerializedName("name")
    public String name;

    @SerializedName("symbol")
    public String symbol;

    @SerializedName("iconUrl")
    public String iconUrl;

    @SerializedName("marketCap")
    public Double marketCap;

    @SerializedName("price")
    public Double price;

    @SerializedName("change")
    public Double change;

    @SerializedName("sparkline")
    public List<Double> listSparkLine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coin)) return false;
        Coin coin = (Coin) o;
        return Objects.equals(rank, coin.rank) &&
                Objects.equals(name, coin.name) &&
                Objects.equals(symbol, coin.symbol) &&
                Objects.equals(iconUrl, coin.iconUrl) &&
                Objects.equals(marketCap, coin.marketCap) &&
                Objects.equals(price, coin.price) &&
                Objects.equals(change, coin.change) &&
                Objects.equals(listSparkLine, coin.listSparkLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, name, symbol, iconUrl, marketCap, price, change, listSparkLine);
    }

    @Override
    public String toString() {
        return "Coin{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", marketCap=" + marketCap +
                ", price=" + price +
                ", change=" + change +
                ", listSparkLine=" + listSparkLine +
                '}';
    }
}
