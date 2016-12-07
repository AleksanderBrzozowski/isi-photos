package com.aleksander.isiphotos.dagger.component;

import com.aleksander.isiphotos.MyApplication;
import com.aleksander.isiphotos.dagger.ActivityBindingModule;
import com.aleksander.isiphotos.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Aleksander
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                ActivityBindingModule.class
        }

)
public interface AppComponent {
    void inject(MyApplication application);
}
