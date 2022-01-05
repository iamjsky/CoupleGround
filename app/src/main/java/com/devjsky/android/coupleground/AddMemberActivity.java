package com.devjsky.android.coupleground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.devjsky.android.coupleground.databinding.ActivityAddMemberBinding;

public class AddMemberActivity extends BaseActivity {

    ActivityAddMemberBinding addMemberBinding;
    AddMemberViewModel addMemberViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        addMemberBinding = ActivityAddMemberBinding.inflate(getLayoutInflater());
        setContentView(addMemberBinding.getRoot());
        super.onCreate(savedInstanceState);

        init();


    }

    void init() {

        setViewModel();
    }

    void setViewModel() {
        addMemberViewModel = new ViewModelProvider(this).get(AddMemberViewModel.class);
        addMemberBinding.setAddMemberViewModel(addMemberViewModel);
        addMemberViewModel.setActivity(this);

    }

}