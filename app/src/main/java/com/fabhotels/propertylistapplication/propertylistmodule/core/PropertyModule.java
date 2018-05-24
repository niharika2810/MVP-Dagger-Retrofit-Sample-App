package com.fabhotels.propertylistapplication.propertylistmodule.core;


import com.fabhotels.propertylistapplication.activity.PropertyListActivity;
import com.fabhotels.propertylistapplication.model.PropertyListResponse;
import com.fabhotels.propertylistapplication.propertylistmodule.api.PropertyListApi;
import com.fabhotels.propertylistapplication.utils.AppUtils;

import rx.Observable;

/**
 * Created by Niharika on 24-05-2018.
 * PropertyModule
 */

public class PropertyModule {

    private PropertyListActivity context;
    private PropertyListApi api;

    public PropertyModule(PropertyListActivity context, PropertyListApi api) {
        this.api = api;
        this.context = context;
    }


    Observable<PropertyListResponse> provideListProperty() {
        return api.getPropertyList();
    }

    Observable<Boolean> isNetworkAvailable() {
        return Observable.just(AppUtils.isNetworkAvailable(context));
    }
}
