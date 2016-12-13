package com.aleksander.isiphotos;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * @author Aleksander
 */

public class RxThreadCallAdapter extends CallAdapter.Factory {

    private final Scheduler observerScheduler;
    private final RxJava2CallAdapterFactory rxJava2CallAdapterFactory;

    public RxThreadCallAdapter(Scheduler observerScheduler, RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        this.observerScheduler = observerScheduler;
        this.rxJava2CallAdapterFactory = rxJava2CallAdapterFactory;
    }


    @Override
    public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return new ThreadCallAdapter(rxJava2CallAdapterFactory.get(returnType, annotations, retrofit));
    }

    class ThreadCallAdapter implements CallAdapter<Object> {

        private final CallAdapter<?> delegateAdapter;

        ThreadCallAdapter(CallAdapter<?> delegateAdapter) {
            this.delegateAdapter = delegateAdapter;
        }

        @Override
        public Type responseType() {
            return delegateAdapter.responseType();
        }

        @Override
        public <T> Object adapt(Call<T> call) {
            return ((Observable<?>)delegateAdapter.adapt(call))
                    .observeOn(observerScheduler);
        }
    }

}
