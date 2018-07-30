package com.willy.example.customcar.screens.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.willy.example.customcar.R;
import com.willy.example.customcar.database.CustomCarDatabase;
import com.willy.example.customcar.databinding.ActivityMainBinding;
import com.willy.example.customcar.enums.AutoPartType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialize database
        CustomCarDatabase.getInstance(this.getApplicationContext())
                .dataDao().getPartsOfType(AutoPartType.TRANSMISSION.getCode());

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new MainViewModel(this));
    }
}
