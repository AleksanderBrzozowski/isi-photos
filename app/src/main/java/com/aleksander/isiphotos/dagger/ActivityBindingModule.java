package com.aleksander.isiphotos.dagger;

import com.aleksander.isiphotos.activity.MainActivity;
import com.aleksander.isiphotos.dagger.component.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author Aleksander
 */

@Module(
        subcomponents = {
                MainActivityComponent.class
        }
)
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    public abstract ActivityComponentBuilder mainActivityComponentBuilder(MainActivityComponent.Builder impl);
}
