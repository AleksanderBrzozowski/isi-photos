package com.aleksander.isiphotos.dagger.component;

import com.aleksander.isiphotos.activity.PhotoDetailsActivity;
import com.aleksander.isiphotos.dagger.ActivityComponent;
import com.aleksander.isiphotos.dagger.ActivityComponentBuilder;
import com.aleksander.isiphotos.dagger.ActivityScope;

import dagger.Subcomponent;

/**
 * @author Aleksander
 */

@ActivityScope
@Subcomponent(
)
public interface PhotoDetailsActivityComponent extends ActivityComponent<PhotoDetailsActivity> {
    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<PhotoDetailsActivityComponent>{
    }
}
