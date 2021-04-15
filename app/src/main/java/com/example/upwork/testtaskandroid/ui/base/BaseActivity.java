package com.example.upwork.testtaskandroid.ui.base;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.upwork.testtaskandroid.R;

public abstract class BaseActivity extends AppCompatActivity {

    protected Integer layoutId;

    protected abstract void initView();

    protected abstract void setupViewModel();

    protected Dialog progressDialog;
    protected BaseViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        progressDialog();
        setupViewModel();
        bindViewModel();
        initView();
    }

    protected void bindViewModel() {
        viewModel.getProgress().observe(this, isInProgress -> {
            if (isInProgress) {
                progressDialog.show();
            } else {
                progressDialog.dismiss();
            }
        });

        viewModel.getMessage().observe(this, message -> Toast.makeText(this, message, Toast.LENGTH_LONG));
    }

    private void progressDialog() {
        progressDialog = new Dialog(this);
        progressDialog.setContentView(R.layout.layout_progress);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT)
        );
    }
}
