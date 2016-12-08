package com.aleksander.isiphotos.dagger;

import com.aleksander.isiphotos.activity.BaseActivity;
import com.aleksander.isiphotos.activity.MainActivity;

import java.util.Map;

import javax.inject.Inject;

/**
 * @author Aleksander
 */

public class ActivityInjectVisitor {

    private final Map<Class<? extends BaseActivity>, ActivityComponentBuilder> activityComponentBuilders;

    @Inject
    public ActivityInjectVisitor(Map<Class<? extends BaseActivity>, ActivityComponentBuilder> activityComponentBuilders) {
        this.activityComponentBuilders = activityComponentBuilders;
    }

    public void visit(MainActivity mainActivity) {
        doInject(activityComponentBuilders.get(MainActivity.class), mainActivity);
    }

    @SuppressWarnings("unchecked")
    private void doInject(ActivityComponentBuilder activityComponentBuilder, BaseActivity baseActivity) {
        activityComponentBuilder.build()
                .injectMembers(baseActivity);
    }

}
