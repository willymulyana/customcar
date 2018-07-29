package com.willy.example.customcar.screens.main;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.willy.example.customcar.enums.AutoPartType;
import com.willy.example.customcar.screens.customize.CustomizeActivity;

public class MainViewModel {

    private Activity activity;

    public MainViewModel(Activity activity) {
        this.activity = activity;
    }

    public void startCustomizing(View v) {
        Intent intent = new Intent(activity, CustomizeActivity.class);
        intent.putExtra("autoPartType", AutoPartType.TRANSMISSION.getCode());
        activity.startActivity(intent);
    }

}
