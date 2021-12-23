package com.devjsky.android.coupleground.net.api;

import com.devjsky.android.coupleground.net.api.model.GetCoupleInfo;
import com.devjsky.android.coupleground.net.api.model.GetUserInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ClassName            ApiService
 * Created by JSky on   2021-12-22
 * <p>
 * Description
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("getUserInfo.php")
    Call<GetUserInfo> getUserInfo(
            @Field("user_token") String user_token
    );
    @FormUrlEncoded
    @POST("getCoupleInfo.php")
    Call<GetCoupleInfo> getCoupleInfo(
            @Field("user_token") String user_token
    );

}
