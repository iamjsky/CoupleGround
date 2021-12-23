package com.devjsky.android.coupleground;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.devjsky.android.coupleground.data.MyConstants;

public class BaseActivity extends AppCompatActivity implements MyConstants {
    public static Context mContext;
    public static Activity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        mActivity = this;
        super.onCreate(savedInstanceState);

        init();
    }

    void init(){
        setViewModel();
    }
    void setViewModel(){}

}