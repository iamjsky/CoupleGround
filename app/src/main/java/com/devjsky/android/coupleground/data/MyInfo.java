package com.devjsky.android.coupleground.data;

import lombok.Data;

/**
 * ClassName            MyInfo
 * Created by JSky on   2021-12-23
 * <p>
 * Description
 */
@Data
public class MyInfo {
    public static MyInfo instance = new MyInfo();
    private boolean isLogin = false;
    private String user_token = "";



}
