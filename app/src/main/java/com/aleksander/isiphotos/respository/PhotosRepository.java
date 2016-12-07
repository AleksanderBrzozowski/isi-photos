package com.aleksander.isiphotos.respository;

import com.aleksander.isiphotos.model.Photo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author Aleksander
 */

public interface PhotosRepository {

    @GET("/photos")
    Observable<List<Photo>> getPhotos();
}
