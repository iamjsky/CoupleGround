package com.devjsky.android.coupleground.data.model;

import lombok.Data;

/**
 * ClassName            CoupleInfo
 * Created by JSky on   2021-12-23
 * <p>
 * Description
 */
@Data
public class CoupleInfo {
    public Integer idx;
    public Integer my_midx;
    public Integer linked_midx;
    public String start_date;
    public Integer elapsed_days;

    public UserInfo user_info;
    public UserInfo linked_user_info;
}
