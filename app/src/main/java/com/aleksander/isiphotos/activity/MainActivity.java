package com.aleksander.isiphotos.activity;

import android.os.Bundle;

import com.aleksander.isiphotos.R;
import com.aleksander.isiphotos.activity.view.MainActivityView;
import com.aleksander.isiphotos.dagger.ActivityInjectVisitor;
import com.aleksander.isiphotos.model.Photo;
import com.aleksander.isiphotos.presenter.MainActivityPresenter;

import java.util.List;

public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void accept(ActivityInjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void showPhotos(List<Photo> photoList) {
    }
}
