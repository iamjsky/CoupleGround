package com.devjsky.android.coupleground;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.devjsky.android.coupleground.data.MyInfo;
import com.devjsky.android.coupleground.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class MainActivity extends BaseActivity {

    ActivityMainBinding mainBinding;

    MainViewModel mainViewModel;
    BottomSheetBehavior bottomSheetBehavior;

    Fragment bottomSheetFragmentPage;


    @Override
    protected void onStart() {

        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        super.onCreate(savedInstanceState);

        init();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    void init() {
        setViewModel();

        bottomSheetBehavior = BottomSheetBehavior.from(mainBinding.layoutBottomSheet);
        int screenSize[] = DisplayUtils.getScreenSize();
        bottomSheetBehavior.setPeekHeight((int)(screenSize[1]/3f),true);
        LOG_I("screenSize : " + screenSize[0] + "," + screenSize[1]);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                LOG_I("newState : " + newState);
                if(newState == BottomSheetBehavior.STATE_EXPANDED){
                    mainBinding.layoutBottomSheet.setBackgroundColor(getResources().getColor(R.color.color_page_background_01));
                }else{
                    mainBinding.layoutBottomSheet.setBackgroundResource(R.drawable.bg_rounded_top_01);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
               // LOG_I("slideOffset : " + slideOffset);
            }
        });
        mainViewModel.login();
        mainViewModel.setElapsedDays();
        setFragmentPage();
    }

    void setViewModel() {

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainBinding.setMainViewModel(mainViewModel);

        mainViewModel.setActivity(this);
        mainViewModel.getElapsedDaysData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mainBinding.tvElapsedDays.setText(s+"");
            }
        });


    }
    public void setFragmentPage() {
        String tag = "";


        bottomSheetFragmentPage = new MainAlertFragment();

        tag =  "";


        if (bottomSheetFragmentPage != null) {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(mainBinding.layoutBottomSheet.getId(), bottomSheetFragmentPage, tag);
            transaction.commitAllowingStateLoss();

        }
    }

}