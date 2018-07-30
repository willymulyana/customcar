package com.willy.example.customcar.screens.result;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.willy.example.customcar.classes.AutoPart;
import com.willy.example.customcar.classes.CustomizationSession;
import com.willy.example.customcar.screens.main.MainActivity;

import java.util.List;

public class ResultViewModel {

    private Activity activity;

    // region binding props

    public String partsStr;
    public int totalPrice;

    // endregion

    public ResultViewModel(Activity activity) {
        this.activity = activity;
        activity.setTitle("RESULT");

        populateData();
    }

    private void populateData() {
        List<AutoPart> autoParts = CustomizationSession.getInstance().getAutoParts();
        partsStr = "";
        totalPrice = 0;
        for (AutoPart part : autoParts) {
            totalPrice += part.getPrice();
            if (part != autoParts.get(autoParts.size() - 1)) { // is not last part
                partsStr += part.getDescription() + ", ";
            } else {
                partsStr += part.getDescription() + ". ";
            }
        }
    }

    public void startOver(View v) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

}
