package com.devjsky.android.coupleground.net.api;

import com.devjsky.android.coupleground.data.MyInfo;
import com.devjsky.android.coupleground.net.RetrofitGenerator;
import com.devjsky.android.coupleground.net.api.callback.GetCoupleInfoCallback;
import com.devjsky.android.coupleground.net.api.callback.GetUserInfoCallback;
import com.devjsky.android.coupleground.net.api.model.GetCoupleInfo;
import com.devjsky.android.coupleground.net.api.model.GetUserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ClassName            UserApi
 * Created by JSky on   2021-12-23
 * <p>
 * Description
 */
public class UserApi implements HttpResponseCode{
    private RetrofitGenerator retrofitGenerator = new RetrofitGenerator();
    private ApiService apiService = retrofitGenerator.getApiService();

    public void getUserInfo(GetUserInfoCallback callback) {

        apiService.getUserInfo(MyInfo.instance.getUser_token()).enqueue(new Callback<GetUserInfo>() {
            @Override
            public void onResponse(Call<GetUserInfo> call, Response<GetUserInfo> response) {
                if (response.isSuccessful()) {
                    GetUserInfo resData = response.body();
                    int code = resData.getHeader().getCode();
                    String msg = resData.getHeader().getMsg();

                    switch (code) {
                        case OK:
                            callback.onSuccess(code, msg, resData.getUser_info());
                            break;

                        case NOT_FOUND:
                        case ERROR:
                            callback.onError(code, msg);
                            break;


                    }




                } else {
                    callback.onError(SERVER_ERROR,"getUserInfo()>>" + "response is not successful");
                }
            }

            @Override
            public void onFailure(Call<GetUserInfo> call, Throwable t) {
                callback.onError(SERVER_ERROR, "getUserInfo()>>" + t.toString());
            }
        });


    }
    public void getCoupleInfo(GetCoupleInfoCallback callback) {

        apiService.getCoupleInfo(MyInfo.instance.getUser_token()).enqueue(new Callback<GetCoupleInfo>() {
            @Override
            public void onResponse(Call<GetCoupleInfo> call, Response<GetCoupleInfo> response) {
                if (response.isSuccessful()) {
                    GetCoupleInfo resData = response.body();
                    int code = resData.getHeader().getCode();
                    String msg = resData.getHeader().getMsg();

                    switch (code) {
                        case OK:
                            callback.onSuccess(code, msg, resData.getCouple_info());
                            break;

                        case NOT_FOUND:
                        case ERROR:
                            callback.onError(code, msg);
                            break;


                    }




                } else {
                    callback.onError(SERVER_ERROR,"getCoupleInfo()>>" + "response is not successful");
                }
            }

            @Override
            public void onFailure(Call<GetCoupleInfo> call, Throwable t) {
                callback.onError(SERVER_ERROR, "getCoupleInfo()>>" + t.toString());
            }
        });


    }
}
