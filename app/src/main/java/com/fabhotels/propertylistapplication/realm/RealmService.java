package com.fabhotels.propertylistapplication.realm;


import com.fabhotels.propertylistapplication.model.PropertyListItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Niharika on 24-05-2018.
 * RealmService
 */
public class RealmService {

    private final Realm mRealm;

    public RealmService(final Realm realm) {
        mRealm = realm;
    }

    private void closeRealm() {
        mRealm.close();
    }

    public List<PropertyListItem> getPropertyList() {
        List<PropertyListItem> propertyListItems = new ArrayList<>();
        RealmResults<PropertyListItem> propertyRealmResult = mRealm.where(PropertyListItem.class).findAll();
        propertyListItems.addAll(mRealm.copyFromRealm(propertyRealmResult));
        closeRealm();
        return propertyListItems;
    }

    public void writeData(List<PropertyListItem> propertyListItems) {
        mRealm.executeTransaction((realm) -> realm.insertOrUpdate(propertyListItems));
    }
}
