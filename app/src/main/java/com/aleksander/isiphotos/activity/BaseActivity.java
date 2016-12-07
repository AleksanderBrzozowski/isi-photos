package com.aleksander.isiphotos.activity;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.aleksander.isiphotos.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * @author Aleksander
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity{

    protected T presenter;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onStart() {
        super.onStart();
        presenter = providePresenter();
        presenter.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    protected abstract T providePresenter();
}
