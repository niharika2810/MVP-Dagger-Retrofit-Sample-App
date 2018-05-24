package com.fabhotels.propertylistapplication.rx;

import rx.Scheduler;

/**
 * Created by Niharika on 24-05-2018.
 * RxSchedulers
 */
public interface RxSchedulers {

    Scheduler androidThread();

    Scheduler internet();


}
