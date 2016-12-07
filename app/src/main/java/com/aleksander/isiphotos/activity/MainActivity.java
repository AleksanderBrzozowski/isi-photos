package com.aleksander.isiphotos.activity;

import android.os.Bundle;

import com.aleksander.isiphotos.MyApplication;
import com.aleksander.isiphotos.R;
import com.aleksander.isiphotos.activity.view.MainActivityView;
import com.aleksander.isiphotos.dagger.component.MainActivityComponent;
import com.aleksander.isiphotos.model.Photo;
import com.aleksander.isiphotos.presenter.MainActivityPresenter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityView{

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityComponent.Builder builder = (MainActivityComponent.Builder) ((MyApplication)getApplication()).getActivityComponentBuilder(this.getClass());
        builder.build().injectMembers(this);
    }

    @Override
    protected MainActivityPresenter providePresenter() {
        return presenter;
    }

    @Override
    public void showPhotos(List<Photo> photoList) {
    }
}
