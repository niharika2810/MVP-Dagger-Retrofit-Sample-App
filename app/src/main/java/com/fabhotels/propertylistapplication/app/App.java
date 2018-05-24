package com.fabhotels.propertylistapplication.app;


import android.app.Application;

import com.fabhotels.propertylistapplication.builder.AppComponent;
import com.fabhotels.propertylistapplication.builder.AppContextModule;
import com.fabhotels.propertylistapplication.builder.DaggerAppComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Niharika on 24-05-2018.
 * Application
 */

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }


    public static AppComponent getNetComponent() {
        return appComponent;
    }

}