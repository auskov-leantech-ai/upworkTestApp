package com.example.upwork.testtaskandroid.ui.adapter;

import android.graphics.RectF;

import com.robinhood.spark.SparkAdapter;

import java.util.List;

public class SparkLineAdapter extends SparkAdapter {

    private final List<Double> sparks;

    public SparkLineAdapter(List<Double> sparks) {
        this.sparks = sparks;
    }

    @Override
    public int getCount() {
        return sparks.size();
    }

    @Override
    public Object getItem(int index) {
        return sparks.get(index);
    }

    @Override
    public float getY(int index) {
        return sparks.get(index).floatValue();
    }

    @Override
    public RectF getDataBounds() {
        RectF bounds = super.getDataBounds();
        bounds.inset(bounds.width(), bounds.height() * 2);
        return bounds;
    }
}
