package com.aleksander.isiphotos.presenter;

import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Aleksander
 */

public abstract class BasePresenter<T> {

    protected T view;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void bind(@NonNull T view){
        this.view = view;
        doAfterBind();
    }

    public void unbind() {
        this.view = null;
        this.compositeDisposable.dispose();
    }

    protected abstract void doAfterBind();
}
