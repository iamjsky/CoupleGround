package com.devjsky.android.coupleground;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.devjsky.android.coupleground.data.MyInfo;
import com.devjsky.android.coupleground.databinding.FragmentMainAlertBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/**
 * ClassName            MainAlertFragment
 * Created by JSky on   2022-01-05
 * <p>
 * Description
 */
public class MainAlertFragment extends BaseFragment {

    FragmentMainAlertBinding mainAlertBinding;
    MainAlertFragmentViewModel mainAlertFragmentViewModel;

    public MainAlertFragment() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainAlertBinding = FragmentMainAlertBinding.inflate(getLayoutInflater());
        init();
        return mainAlertBinding.getRoot();

    }



    void init() {


        setViewModel();
    }


    void setViewModel() {
        mainAlertFragmentViewModel = new ViewModelProvider(this).get(MainAlertFragmentViewModel.class);
        mainAlertBinding.setMainAlertFragmentViewModel(mainAlertFragmentViewModel);
        mainAlertFragmentViewModel.setActivity(mParent);

    }

    public void setLoggedLayout(){
        String userToken = MyInfo.instance.getUser_token() + "";
        boolean isLogin = MyInfo.instance.isLogin();
        LOG_E("userToken : " + userToken + ", isLogin : " + isLogin);
        if(!userToken.equals("") && isLogin){
            mainAlertBinding.layoutUserLogged.setVisibility(View.VISIBLE);
            mainAlertBinding.layoutUserNeedLogin.setVisibility(View.GONE);
        }else{
            mainAlertBinding.layoutUserLogged.setVisibility(View.GONE);
            mainAlertBinding.layoutUserNeedLogin.setVisibility(View.VISIBLE);
        }
    }



}
