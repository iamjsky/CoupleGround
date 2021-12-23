package com.devjsky.android.coupleground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devjsky.android.coupleground.data.MyInfo;
import com.devjsky.android.coupleground.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity {

    ActivityMainBinding mainBinding;

    MainViewModel mainViewModel;
    @Override
    protected void onStart() {

        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        super.onCreate(savedInstanceState);


    }

    @Override
    void init() {
        super.init();
        mainViewModel.login();
        mainViewModel.setElapsedDays();

    }

    @Override
    void setViewModel() {
        super.setViewModel();

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

    public void moveAddMemberAct(View view){
        Intent intent = new Intent(this, AddMemberActivity.class);
        startActivity(intent);
    }

    public void setLoggedLayout(){
        String userToken = MyInfo.instance.getUser_token() + "";
        boolean isLogin = MyInfo.instance.isLogin();
        LOG_E("userToken : " + userToken + ", isLogin : " + isLogin);
        if(!userToken.equals("") && isLogin){
            mainBinding.layoutElapsedDays.setVisibility(View.VISIBLE);
        }else{
            mainBinding.layoutElapsedDays.setVisibility(View.GONE);
        }
    }
}