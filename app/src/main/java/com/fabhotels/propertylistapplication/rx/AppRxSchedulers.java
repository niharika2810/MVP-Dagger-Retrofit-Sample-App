package com.fabhotels.propertylistapplication.rx;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Niharika on 24-05-2018.
 * AppRxSchedulers
 */

public class AppRxSchedulers implements RxSchedulers {

    private static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler INTERNET_SCHEDULERS = Schedulers.from(internetExecutor);

    @Override
    public Scheduler androidThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler internet() {
        return INTERNET_SCHEDULERS;
    }
}
