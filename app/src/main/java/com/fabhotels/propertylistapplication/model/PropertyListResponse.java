package com.fabhotels.propertylistapplication.model;

import java.util.List;

/**
 * Created by Niharika on 24-05-2018.
 * PropertyListItem
 */
public class PropertyListResponse {
    private List<PropertyListItem> propertyListing;

    public void setPropertyListing(List<PropertyListItem> propertyListing) {
        this.propertyListing = propertyListing;
    }

    public List<PropertyListItem> getPropertyListing() {
        return propertyListing;
    }

}