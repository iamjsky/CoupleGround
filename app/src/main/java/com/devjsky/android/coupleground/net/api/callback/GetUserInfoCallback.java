package com.devjsky.android.coupleground.net.api.callback;
import com.devjsky.android.coupleground.data.model.UserInfo;
import com.devjsky.android.coupleground.net.api.model.HttpBaseHeader;

/**
 * ClassName            GetUserInfoCallback
 * Created by JSky on   2021-12-23
 * <p>
 * Description
 */
public interface GetUserInfoCallback {
    void onSuccess(Integer code, String msg, UserInfo userInfo);
    void onError(Integer code, String msg);
}
