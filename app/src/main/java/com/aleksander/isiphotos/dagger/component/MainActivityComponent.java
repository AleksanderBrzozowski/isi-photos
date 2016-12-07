package com.aleksander.isiphotos.dagger.component;

import com.aleksander.isiphotos.activity.MainActivity;
import com.aleksander.isiphotos.dagger.ActivityComponent;
import com.aleksander.isiphotos.dagger.ActivityComponentBuilder;
import com.aleksander.isiphotos.dagger.ActivityScope;
import com.aleksander.isiphotos.dagger.module.ApiModule;
import com.aleksander.isiphotos.dagger.module.MainActivityModule;

import dagger.Subcomponent;

/**
 * @author Aleksander
 */
@ActivityScope
@Subcomponent(
        modules = {
                MainActivityModule.class,
                ApiModule.class
        }
)
public interface MainActivityComponent extends ActivityComponent<MainActivity> {
    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MainActivityComponent> {
    }
}
