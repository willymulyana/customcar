package com.willy.example.customcar.screens.customize;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.willy.example.customcar.R;
import com.willy.example.customcar.databinding.ActivityCustomizeBinding;
import com.willy.example.customcar.enums.AutoPartType;

public class CustomizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AutoPartType type = AutoPartType.valueOf(
                getIntent().getIntExtra("autoPartType", AutoPartType.TRANSMISSION.getCode())
        );

        ActivityCustomizeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_customize);
        binding.setViewModel(new CustomizeViewModel(this, type));
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
