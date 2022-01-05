package com.devjsky.android.coupleground;

import android.app.Activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devjsky.android.coupleground.data.MyInfo;
import com.devjsky.android.coupleground.data.model.CoupleInfo;
import com.devjsky.android.coupleground.data.model.UserInfo;
import com.devjsky.android.coupleground.net.api.callback.GetCoupleInfoCallback;
import com.devjsky.android.coupleground.net.api.callback.GetUserInfoCallback;

import lombok.Data;

/**
 * ClassName            MainViewModel
 * Created by JSky on   2021-12-22
 * <p>
 * Description
 */
@Data
public class MainViewModel extends BaseViewModel {


   // private String elapsedDays = "0000";
    public MutableLiveData<String> elapsedDaysData = new MutableLiveData<String>();
    public MainViewModel(){}


    void init(){

    }

    public void login(){
        MyInfo.instance.setUser_token("test1");
        MyInfo.instance.setLogin(true);
       // ((MainActivity)mActivity).setLoggedLayout();

    }
    public void logout(){
        MyInfo.instance.setUser_token("");
        MyInfo.instance.setLogin(false);
        //((MainActivity)mActivity).setLoggedLayout();
    }
    public void setElapsedDays(){
        setLoading(true, mActivity);
        userApi.getCoupleInfo(new GetCoupleInfoCallback() {
            @Override
            public void onSuccess(Integer code, String msg, CoupleInfo coupleInfo) {
                setLoading(false, mActivity);
                String elapsedDays = coupleInfo.getElapsed_days()+"";
                elapsedDaysData.setValue(elapsedDays + "일");
            }

            @Override
            public void onError(Integer code, String msg) {
                setLoading(false, mActivity);
            }
        });

    }
}
