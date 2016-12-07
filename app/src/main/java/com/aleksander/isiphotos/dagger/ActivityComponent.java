package com.aleksander.isiphotos.dagger;

import com.aleksander.isiphotos.activity.BaseActivity;

import dagger.MembersInjector;

/**
 * @author Aleksander
 */

public interface ActivityComponent<T extends BaseActivity> extends MembersInjector<T> {
}
