package com.aleksander.isiphotos.dagger.module;

import com.aleksander.isiphotos.dagger.ActivityScope;
import com.aleksander.isiphotos.respository.PhotosRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Aleksander
 */

@Module
public class ApiModule {

    @Provides
    @ActivityScope
    PhotosRepository providePhotosRepository(Retrofit retrofit) {
        return retrofit.create(PhotosRepository.class);
    }
}
