package com.aleksander.isiphotos;

import android.app.Application;

import com.aleksander.isiphotos.dagger.ActivityInjectVisitor;
import com.aleksander.isiphotos.dagger.component.DaggerAppComponent;
import com.aleksander.isiphotos.dagger.module.AppModule;

import javax.inject.Inject;


/**
 * @author Aleksander
 */
public class MyApplication extends Application {

    @Inject
    ActivityInjectVisitor activityInjectVisitor;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build()
                .inject(this);
    }

    public ActivityInjectVisitor getActivityInjectVisitor() {
        return activityInjectVisitor;
    }
}
