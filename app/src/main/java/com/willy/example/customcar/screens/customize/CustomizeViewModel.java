package com.willy.example.customcar.screens.customize;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.willy.example.customcar.BR;
import com.willy.example.customcar.R;
import com.willy.example.customcar.classes.AutoPart;
import com.willy.example.customcar.classes.AutoPartFactory;
import com.willy.example.customcar.database.CustomCarDatabase;
import com.willy.example.customcar.enums.AutoPartType;
import com.willy.example.customcar.screens.result.ResultActivity;

import java.util.ArrayList;
import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class CustomizeViewModel extends BaseObservable {

    private Activity activity;
    private AutoPartType type;

    public String nextBtnLabel;
    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public List<AutoPart> parts = new ArrayList<>();

    @Bindable
    public AutoPart selectedPart;
    public ItemBinding<AutoPart> autoPartItemRenderer = ItemBinding.of(BR.item, R.layout.autopart_spinner_item);
    public Spinner.OnItemSelectedListener autoPartSelectedListener = new Spinner.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (selectedPart == parts.get(position)) return;
            selectedPart = parts.get(position);
            notifyPropertyChanged(BR.selectedPart);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    // region constructor

    public CustomizeViewModel(Activity activity, AutoPartType type) {
        this.activity = activity;
        this.type = type;

        getAutoParts();

        activity.setTitle("CUSTOMIZE YOUR " + type.name());
        if (type == AutoPartType.PAINT) {
            nextBtnLabel = "DONE";
        } else {
            nextBtnLabel = "NEXT";
        }
    }

    // endregion

    public void getAutoParts() {
        AutoPartFactory factory = new AutoPartFactory();
        List<AutoPart> dbParts = CustomCarDatabase.getInstance(activity).dataDao().getPartsOfType(type.getCode());
        for (AutoPart part : dbParts) {
            parts.add(factory.getAutoPart(part.getType(), part.getName(), part.getDescription(), part.getPrice()));
        }
        if (parts.size() > 0) {
            selectedPart = parts.get(0);
            isLoading.set(false);
        }
    }

    @BindingAdapter("setPartChangeListener")
    public static void setPartChangeListener(Spinner spinner, Spinner.OnItemSelectedListener listener) {
        spinner.setOnItemSelectedListener(listener);
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
