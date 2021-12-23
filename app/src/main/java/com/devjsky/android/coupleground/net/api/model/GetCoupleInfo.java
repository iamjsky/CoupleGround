package com.devjsky.android.coupleground.net.api.model;

import com.devjsky.android.coupleground.data.model.CoupleInfo;

import lombok.Data;

/**
 * ClassName            GetCoupleInfo
 * Created by JSky on   2021-12-23
 * <p>
 * Description
 */
@Data
public class GetCoupleInfo {
    public HttpBaseHeader header;
    public CoupleInfo couple_info;
}
