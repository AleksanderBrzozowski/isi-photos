package com.aleksander.isiphotos;

import android.app.Application;

import com.aleksander.isiphotos.activity.BaseActivity;
import com.aleksander.isiphotos.dagger.ActivityComponentBuilder;
import com.aleksander.isiphotos.dagger.HasActivitySubComponentBuilders;
import com.aleksander.isiphotos.dagger.component.DaggerAppComponent;

import java.util.Map;

import javax.inject.Inject;


/**
 * @author Aleksander
 */
public class MyApplication extends Application implements HasActivitySubComponentBuilders {

    @Inject
    Map<Class<? extends BaseActivity>, ActivityComponentBuilder> activityComponentBuilders;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.create()
                .inject(this);
    }

    @Override
    public ActivityComponentBuilder getActivityComponentBuilder(Class<? extends BaseActivity> activityClass) {
        return activityComponentBuilders.get(activityClass);
    }
}
