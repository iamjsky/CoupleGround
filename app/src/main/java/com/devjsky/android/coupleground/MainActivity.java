package com.devjsky.android.coupleground;

import androidx.appcompat.app.AppCompatActivity;
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
            mainBinding.layoutUserLogged.setVisibility(View.VISIBLE);
            mainBinding.layoutUserNeedLogin.setVisibility(View.GONE);
        }else{
            mainBinding.layoutUserLogged.setVisibility(View.GONE);
            mainBinding.layoutUserNeedLogin.setVisibility(View.VISIBLE);
        }
    }

    public void btn_clicked(View view){
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }
}