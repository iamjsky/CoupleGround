package com.devjsky.android.coupleground;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.devjsky.android.coupleground.data.MyConstants;

/**
 * ClassName            BaseFragment
 * Created by JSky on   2022-01-05
 * <p>
 * Description
 */
public class BaseFragment extends Fragment  implements MyConstants {

    protected BaseActivity mParent;

    protected String pageTag = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageTag = getTag() +"";
        mParent = (BaseActivity) getActivity();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);

    }


}
