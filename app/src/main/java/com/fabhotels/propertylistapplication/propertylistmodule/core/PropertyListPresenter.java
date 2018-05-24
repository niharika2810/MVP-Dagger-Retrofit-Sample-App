package com.fabhotels.propertylistapplication.propertylistmodule.core;

import android.util.Log;

import com.fabhotels.propertylistapplication.realm.RealmService;
import com.fabhotels.propertylistapplication.rx.RxSchedulers;
import com.fabhotels.propertylistapplication.utils.AppUtils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Niharika on 24-05-2018.
 * PropertyListPresenter
 */

public class PropertyListPresenter {

    private PropertyListView mPropertyListView;
    private PropertyModule model;
    private RxSchedulers rxSchedulers;
    private CompositeSubscription subscriptions;
    private RealmService realmService;

    public PropertyListPresenter(RxSchedulers schedulers, PropertyModule model, PropertyListView propertyListView, CompositeSubscription sub, RealmService realmService) {
        this.rxSchedulers = schedulers;
        this.mPropertyListView = propertyListView;
        this.model = model;
        this.subscriptions = sub;
        this.realmService = realmService;

    }

    public void onCreate() {
        subscriptions.add(getPropertyList());
    }

    public void onDestroy() {
        subscriptions.clear();
    }


    private Subscription getPropertyList() {

        mPropertyListView.showWait();
        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                mPropertyListView.getActivityContext().runOnUiThread(() -> {
                    mPropertyListView.removeWait();
                    mPropertyListView.swapAdapter(realmService.getPropertyList());
                });
                Log.d("no conn", "no connexion");
            }
        }).filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.provideListProperty()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(propertyList -> {
                    mPropertyListView.removeWait();
                    realmService.writeData(propertyList.getPropertyListing());
                    mPropertyListView.swapAdapter(this.realmService.getPropertyList());
                }, AppUtils::handleThrowable
        );

    }

}
