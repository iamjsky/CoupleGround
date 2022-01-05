package com.devjsky.android.coupleground;

import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.devjsky.android.coupleground.data.MyInfo;

/**
 * ClassName            MainAlertFragmentViewModel
 * Created by JSky on   2022-01-05
 * <p>
 * Description
 */
public class MainAlertFragmentViewModel extends BaseViewModel {

    public MainAlertFragmentViewModel(){}


    void init(){

    }

    public void moveAct(){
        Log.e("ettetete", "moveAct");
        Intent intent = new Intent(mActivity, AddMemberActivity.class);
        mActivity.startActivity(intent);

    }

}
