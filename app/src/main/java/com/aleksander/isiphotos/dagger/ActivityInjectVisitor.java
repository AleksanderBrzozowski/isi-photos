package com.aleksander.isiphotos.dagger;

import com.aleksander.isiphotos.activity.BaseActivity;
import com.aleksander.isiphotos.activity.MainActivity;
import com.aleksander.isiphotos.activity.PhotoDetailsActivity;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Aleksander
 */

@Singleton
public class ActivityInjectVisitor {

    private final Map<Class<? extends BaseActivity>, ActivityComponentBuilder> activityComponentBuilders;

    @Inject
    public ActivityInjectVisitor(Map<Class<? extends BaseActivity>, ActivityComponentBuilder> activityComponentBuilders) {
        this.activityComponentBuilders = activityComponentBuilders;
    }

    @SuppressWarnings("unchecked")
    private void doInject(ActivityComponentBuilder activityComponentBuilder, BaseActivity baseActivity) {
        activityComponentBuilder.build()
                .injectMembers(baseActivity);
    }

    public void visit(MainActivity mainActivity) {
        doInject(activityComponentBuilders.get(MainActivity.class), mainActivity);
    }

    public void accept(PhotoDetailsActivity photoDetailsActivity) {
        doInject(activityComponentBuilders.get(PhotoDetailsActivity.class), photoDetailsActivity);
    }
}
