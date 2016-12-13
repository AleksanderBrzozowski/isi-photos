package com.aleksander.isiphotos;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */



public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        Runnable runnable = () -> System.out.println("run");
        runnable.run();

        Observable<String> observable = Observable.just("String");
        observable.doOnNext(s -> System.out.println(Thread.currentThread().toString()))
                .subscribeOn(Schedulers.trampoline())
                .subscribe(
                        s -> System.out.println(Thread.currentThread().toString())
                );
    }
}