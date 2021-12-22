package com.devjsky.android.coupleground.net.api;

import com.devjsky.android.coupleground.model.CGUser;

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
    public CGUser user_info;
}
