package com.fabhotels.propertylistapplication.propertylistmodule.api;



import com.fabhotels.propertylistapplication.model.PropertyListResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Niharika on 24-05-2018.
 * PropertyListApi
 */
public interface PropertyListApi {
    @GET("/bins/bs67u")
    Observable<PropertyListResponse> getPropertyList();
}
