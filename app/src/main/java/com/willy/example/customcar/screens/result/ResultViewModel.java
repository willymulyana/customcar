package com.willy.example.customcar.screens.result;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.willy.example.customcar.screens.main.MainActivity;

public class ResultViewModel {

    private Activity activity;

    public ResultViewModel(Activity activity) {
        this.activity = activity;
        activity.setTitle("RESULT");
    }

    public void startOver(View v) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

}
