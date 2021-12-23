package com.devjsky.android.coupleground;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.devjsky.android.coupleground.net.api.UserApi;

/**
 * ClassName            BaseViewModel
 * Created by JSky on   2021-12-23
 * <p>
 * Description
 */
public class BaseViewModel extends ViewModel {

    protected Activity mActivity;
    LoadingDialog loadingDialog = null;

    UserApi userApi = new UserApi();

    public BaseViewModel() {
        init();
    }

    void init(){

    }

    public void setActivity(Activity activity){
        mActivity = activity;

    }
    public void setLoading(boolean value, Context context) {

        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(context);
        }

        if (value) {

            loadingDialog.show();
        } else {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }

        }




    }

}
