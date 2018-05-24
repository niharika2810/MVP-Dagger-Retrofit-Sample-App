package com.fabhotels.propertylistapplication.propertylistmodule.dagger;


import com.fabhotels.propertylistapplication.activity.PropertyListActivity;
import com.fabhotels.propertylistapplication.builder.AppComponent;

import dagger.Component;

/**
 * Created by Niharika on 24-05-2018.
 * PropertyListComponent
 */
@PropertyListScope
@Component(dependencies = {AppComponent.class}, modules = {PropertyListModule.class})
public interface PropertyListComponent {
    void inject(PropertyListActivity heroesActivity);
}
