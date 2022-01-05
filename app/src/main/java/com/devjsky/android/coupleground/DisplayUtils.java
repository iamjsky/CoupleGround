package com.devjsky.android.coupleground;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * ClassName            DisplayUtils
 * Created by JSky on   2022-01-05
 * <p>
 * Description
 */
public class DisplayUtils {

    public static int[] getScreenSize(){
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        int[] screenSize = {width, height};
        return screenSize;

    }
}
