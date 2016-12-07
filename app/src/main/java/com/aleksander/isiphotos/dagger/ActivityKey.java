package com.aleksander.isiphotos.dagger;

import com.aleksander.isiphotos.activity.BaseActivity;

import dagger.MapKey;

/**
 * @author Aleksander
 */

@MapKey
public @interface ActivityKey {
    Class<? extends BaseActivity> value();
}
