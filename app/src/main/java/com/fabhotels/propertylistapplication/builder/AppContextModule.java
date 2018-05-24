package com.fabhotels.propertylistapplication.builder;

import android.content.Context;


import com.fabhotels.propertylistapplication.realm.RealmService;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by Niharika on 24-05-2018.
 * AppContextModule
 */
@Module
public class AppContextModule {


    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }


    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    RealmService provideRealmService(final Realm realm) {
        return new RealmService(realm);
    }
}
