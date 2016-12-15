package com.aleksander.isiphotos.activity;

import android.os.Bundle;

import com.aleksander.isiphotos.R;
import com.aleksander.isiphotos.dagger.ActivityInjectVisitor;
import com.aleksander.isiphotos.presenter.PhotoDetailsPresenter;

public class PhotoDetailsActivity extends BaseActivity<PhotoDetailsPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);
    }

    @Override
    protected void accept(ActivityInjectVisitor visitor) {
        visitor.accept(this);
    }
}
