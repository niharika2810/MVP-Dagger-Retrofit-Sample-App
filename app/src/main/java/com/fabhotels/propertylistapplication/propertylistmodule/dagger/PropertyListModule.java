package com.fabhotels.propertylistapplication.propertylistmodule.dagger;


import com.fabhotels.propertylistapplication.activity.PropertyListActivity;
import com.fabhotels.propertylistapplication.propertylistmodule.api.PropertyListApi;
import com.fabhotels.propertylistapplication.propertylistmodule.core.PropertyListPresenter;
import com.fabhotels.propertylistapplication.propertylistmodule.core.PropertyListView;
import com.fabhotels.propertylistapplication.propertylistmodule.core.PropertyModule;
import com.fabhotels.propertylistapplication.realm.RealmService;
import com.fabhotels.propertylistapplication.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Niharika on 24-05-2018.
 * PropertyListModule
 */
@Module
public class PropertyListModule {

    private PropertyListActivity mPropertyActivityContext;

    public PropertyListModule(PropertyListActivity context) {
        this.mPropertyActivityContext = context;
    }


    @PropertyListScope
    @Provides
    PropertyListView provideView() {
        return new PropertyListView(mPropertyActivityContext);
    }

    @PropertyListScope
    @Provides
    PropertyListPresenter providePresenter(RxSchedulers schedulers, PropertyListView view, PropertyModule model, RealmService realmService) {
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new PropertyListPresenter(schedulers, model, view, subscriptions, realmService);
    }

    @PropertyListScope
    @Provides
    PropertyListActivity provideContext() {
        return mPropertyActivityContext;
    }

    @PropertyListScope
    @Provides
    PropertyModule provideModel(PropertyListApi api) {
        return new PropertyModule(mPropertyActivityContext, api);
    }
}
