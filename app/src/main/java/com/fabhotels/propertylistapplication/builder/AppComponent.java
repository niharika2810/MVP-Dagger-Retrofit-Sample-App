package com.fabhotels.propertylistapplication.builder;

import android.content.Context;

import com.fabhotels.propertylistapplication.propertylistmodule.api.PropertyListApi;
import com.fabhotels.propertylistapplication.realm.RealmService;
import com.fabhotels.propertylistapplication.rx.RxSchedulers;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by Niharika on 24-05-2018.
 * AppComponent
 */
@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, PropertyApiServiceModule.class})
public interface AppComponent {

    RealmService getRealmInstance();

    Realm getRealm();

    RxSchedulers rxSchedulers();

    PropertyListApi getPropertyListService();

}
