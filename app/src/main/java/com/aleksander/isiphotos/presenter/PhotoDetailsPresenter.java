package com.aleksander.isiphotos.presenter;

import com.aleksander.isiphotos.activity.view.PhotoDetailsView;
import com.aleksander.isiphotos.dagger.ActivityScope;
import com.aleksander.isiphotos.model.Photo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

/**
 * @author Aleksander
 */

@ActivityScope
public class PhotoDetailsPresenter extends EventPresenter<PhotoDetailsView> {


    @Inject
    public PhotoDetailsPresenter(EventBus eventBus) {
        super(eventBus);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onPhotoReceived(Photo photo) {
        view.setPhoto(photo);
        eventBus.removeStickyEvent(photo);
    }
}
