package com.fabhotels.propertylistapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.fabhotels.propertylistapplication.app.App;
import com.fabhotels.propertylistapplication.propertylistmodule.core.PropertyListPresenter;
import com.fabhotels.propertylistapplication.propertylistmodule.core.PropertyListView;
import com.fabhotels.propertylistapplication.propertylistmodule.dagger.DaggerPropertyListComponent;
import com.fabhotels.propertylistapplication.propertylistmodule.dagger.PropertyListModule;

import javax.inject.Inject;


public class PropertyListActivity extends AppCompatActivity {
    //Dagger-MVP-RX
    @Inject
    PropertyListView view;
    @Inject
    PropertyListPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerPropertyListComponent.builder().appComponent(App.getNetComponent()).propertyListModule(new PropertyListModule(this)).build().inject(this);
        presenter.onCreate();
        setContentView(view.getPropertyListView());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
