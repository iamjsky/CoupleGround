package com.devjsky.android.coupleground;

import android.content.Context;
import android.os.Bundle;



/**
 * ClassName            LoadingDialog
 * Created by JSky on   2021-10-08
 * <p>
 * Description
 */
public class LoadingDialog extends BaseDialog {




    Context mContext;

    public LoadingDialog(Context context) {
        super(context);
        mContext = context;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);



    }





}
