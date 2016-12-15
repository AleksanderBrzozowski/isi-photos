package com.aleksander.isiphotos.presenter;

import com.aleksander.isiphotos.activity.view.MainActivityView;
import com.aleksander.isiphotos.dagger.ActivityScope;
import com.aleksander.isiphotos.model.Photo;
import com.aleksander.isiphotos.service.PhotosService;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * @author Aleksander
 */

@ActivityScope
public class MainActivityPresenter extends BasePresenter<MainActivityView> implements OnItemClickListener<Photo> {

    private final PhotosService photosService;
    private final EventBus eventBus;

    @Inject
    public MainActivityPresenter(PhotosService photosService, EventBus eventBus) {
        this.photosService = photosService;
        this.eventBus = eventBus;
    }

    @Override
    protected void doAfterBind() {
        getPhotos();
    }

    public void getPhotos() {
        compositeDisposable.add(
                photosService.getPhotos()
                        .subscribe(
                                photos -> view.showPhotos(photos),
                                Throwable::printStackTrace
                        ));
    }

    @Override
    public void onItemClicked(Photo item) {
        eventBus.postSticky(item);
        view.startDetailsActivity(item);
    }
}
