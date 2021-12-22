package com.devjsky.android.coupleground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.devjsky.android.coupleground.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        super.onCreate(savedInstanceState);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainBinding.setMainViewModel(mainViewModel);






        mainViewModel.getTestText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mainBinding.includeMainBody.tvText.setText(s+"");

            }
        });
        mainViewModel.getTestText2().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mainBinding.includeMainTopBar.tvTop.setText(s+"");

            }
        });
    }
}