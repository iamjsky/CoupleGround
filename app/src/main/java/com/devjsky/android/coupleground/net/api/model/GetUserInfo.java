package com.devjsky.android.coupleground.net.api.model;

import com.devjsky.android.coupleground.data.model.UserInfo;

import lombok.Data;

/**
 * ClassName            CGUser
 * Created by JSky on   2021-12-22
 * <p>
 * Description
 */
@Data
public class GetUserInfo {
    public HttpBaseHeader header;
    public UserInfo user_info;
}
