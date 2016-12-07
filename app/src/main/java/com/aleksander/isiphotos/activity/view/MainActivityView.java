package com.aleksander.isiphotos.activity.view;

import com.aleksander.isiphotos.model.Photo;

import java.util.List;

/**
 * @author Aleksander
 */

public interface MainActivityView {
    void showPhotos(List<Photo> photoList);
}
