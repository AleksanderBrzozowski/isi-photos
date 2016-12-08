package com.aleksander.isiphotos.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aleksander.isiphotos.MyApplication;
import com.aleksander.isiphotos.dagger.ActivityInjectVisitor;
import com.aleksander.isiphotos.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * @author Aleksander
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity{

    @Inject
    protected T presenter;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accept(((MyApplication)getApplication()).getActivityInjectVisitor());
        presenter.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    protected abstract void accept(ActivityInjectVisitor visitor);
}
