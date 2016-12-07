package com.aleksander.isiphotos.dagger;

import com.aleksander.isiphotos.activity.BaseActivity;

/**
 * @author Aleksander
 */

public interface HasActivitySubComponentBuilders {
    ActivityComponentBuilder getActivityComponentBuilder(Class<? extends BaseActivity> activityClass);
}
