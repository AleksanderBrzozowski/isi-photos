package com.aleksander.isiphotos.service;

import com.aleksander.isiphotos.dagger.ActivityScope;
import com.aleksander.isiphotos.model.Photo;
import com.aleksander.isiphotos.respository.PhotosRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author Aleksander
 */

@ActivityScope
public class PhotosService {

    private final PhotosRepository photosRepository;

    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }


    public Observable<List<Photo>> getPhotos() {
        return photosRepository.getPhotos();
    }
}
