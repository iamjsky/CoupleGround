package com.devjsky.android.coupleground.data;

import android.util.Log;

/**
 * ClassName            MyConstants
 * Created by JSky on   2021-12-23
 * <p>
 * Description
 */
public interface MyConstants {
    String TAG = "cg_debug";
    boolean DEBUG_MODE = true;

    default void LOG_D(String msg){
        if(DEBUG_MODE){
            Log.d(TAG, msg);
        }
    }
    default void LOG_I(String msg){
        if(DEBUG_MODE){
            Log.i(TAG, msg);
        }
    }
    default void LOG_E(String msg){
        if(DEBUG_MODE){
            Log.e(TAG, msg);
        }
    }
}
