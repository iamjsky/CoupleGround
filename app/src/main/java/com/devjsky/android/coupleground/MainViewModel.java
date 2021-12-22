package com.devjsky.android.coupleground;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import lombok.Data;

/**
 * ClassName            MainViewModel
 * Created by JSky on   2021-12-22
 * <p>
 * Description
 */
@Data
public class MainViewModel extends ViewModel {
    public MutableLiveData<String> testText = new MutableLiveData<String>();
    public MutableLiveData<String> testText2 = new MutableLiveData<String>();
    private String mTestText = "HI";
    private String mTestText2 = "menu";

    public MainViewModel() {
        testText.setValue(mTestText);
        testText2.setValue(mTestText2);
    }
}
