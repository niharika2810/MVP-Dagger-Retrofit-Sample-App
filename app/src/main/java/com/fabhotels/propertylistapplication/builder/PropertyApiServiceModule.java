package com.fabhotels.propertylistapplication.builder;


import com.fabhotels.propertylistapplication.propertylistmodule.api.PropertyListApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Niharika on 24-05-2018.
 * PropertyApiServiceModule
 */

@Module
class PropertyApiServiceModule {

    private static final String BASE_URL = "https://api.myjson.com";

    @AppScope
    @Provides
    PropertyListApi provideApiService(Retrofit retrofit) {
        return retrofit.create(PropertyListApi.class);
    }


}
