package com.aleksander.isiphotos.presenter;

import com.aleksander.isiphotos.activity.view.PhotoDetailsView;
import com.aleksander.isiphotos.dagger.ActivityScope;

import javax.inject.Inject;

/**
 * @author Aleksander
 */

@ActivityScope
public class PhotoDetailsPresenter extends BasePresenter<PhotoDetailsView> {

    @Inject
    public PhotoDetailsPresenter() {
    }

    @Override
    protected void doAfterBind() {

    }
}
