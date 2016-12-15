package com.aleksander.isiphotos.presenter;

import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

/**
 * @author Aleksander
 */

public class EventPresenter<T> extends BasePresenter<T> {

    protected final EventBus eventBus;

    public EventPresenter(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void bind(@NonNull T view) {
        super.bind(view);
        eventBus.register(this);
    }

    @Override
    public void unbind() {
        super.unbind();
        eventBus.unregister(this);
    }
}
