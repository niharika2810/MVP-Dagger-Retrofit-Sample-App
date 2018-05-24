package com.fabhotels.propertylistapplication.builder;

import com.fabhotels.propertylistapplication.rx.AppRxSchedulers;
import com.fabhotels.propertylistapplication.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Niharika on 24-05-2018.
 * RxModule
 */

@Module
class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}
