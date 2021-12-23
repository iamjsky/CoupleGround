package com.devjsky.android.coupleground.net.api.callback;
import com.devjsky.android.coupleground.data.model.CoupleInfo;
import com.devjsky.android.coupleground.data.model.UserInfo;

/**
 * ClassName            GetUserInfoCallback
 * Created by JSky on   2021-12-23
 * <p>
 * Description
 */
public interface GetCoupleInfoCallback {
    void onSuccess(Integer code, String msg, CoupleInfo coupleInfo);
    void onError(Integer code, String msg);
}
