package com.willy.example.customcar.screens.customize;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.willy.example.customcar.enums.AutoPartType;
import com.willy.example.customcar.screens.result.ResultActivity;

public class CustomizeViewModel {

    private Activity activity;
    private AutoPartType type;

    public String nextBtnLabel;

    public CustomizeViewModel(Activity activity, AutoPartType type) {
        this.activity = activity;
        this.type = type;

        activity.setTitle("CUSTOMIZE YOUR " + type.name());
        if (type == AutoPartType.PAINT) {
            nextBtnLabel = "DONE";
        } else {
            nextBtnLabel = "NEXT";
        }
    }

    public void next(View v) {
        Intent intent;
        if (type == AutoPartType.PAINT) {
            intent = new Intent(activity, ResultActivity.class);
        } else {
            intent = new Intent(activity, CustomizeActivity.class);
            intent.putExtra("autoPartType", this.type.getCode() + 1);
        }
        activity.startActivity(intent);
    }

}
