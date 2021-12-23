package com.devjsky.android.coupleground.data.model;

import lombok.Data;

/**
 * ClassName            CGUser
 * Created by JSky on   2021-12-22
 * <p>
 * Description
 */
@Data
public class UserInfo {
    public Integer idx;
    public String user_name;
    public String user_nickname;
    public String user_phone_number;
    public String user_email;
    public String user_profile_img;
    public Integer linked_state;

}
