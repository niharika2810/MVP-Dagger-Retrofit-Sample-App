package com.fabhotels.propertylistapplication.propertylistmodule.core;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.fabhotels.propertylistapplication.R;
import com.fabhotels.propertylistapplication.activity.PropertyListActivity;
import com.fabhotels.propertylistapplication.adapter.PropertyListAdapter;
import com.fabhotels.propertylistapplication.interfaces.ProgressViewCallbacks;
import com.fabhotels.propertylistapplication.model.PropertyListItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Niharika on 24-05-2018.
 * PropertyListView
 */

public class PropertyListView implements ProgressViewCallbacks {

    @BindView(R.id.recycler_view)
    RecyclerView propertyListRecyclerView;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    private PropertyListAdapter mPropertyListAdapter;
    private View mView;
    private PropertyListActivity activityContext;

    public PropertyListView(PropertyListActivity activityContext) {
        this.activityContext = activityContext;
        FrameLayout parent = new FrameLayout(activityContext);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mView = LayoutInflater.from(activityContext).inflate(R.layout.activity_property, parent, true);
        ButterKnife.bind(this, mView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activityContext);
        propertyListRecyclerView.setLayoutManager(linearLayoutManager);
        mPropertyListAdapter = new PropertyListAdapter(activityContext);
        propertyListRecyclerView.setAdapter(mPropertyListAdapter);
    }


    public View getPropertyListView() {
        return mView;
    }

    Activity getActivityContext() {
        return activityContext;
    }


    void swapAdapter(List<PropertyListItem> propertyList) {
        mPropertyListAdapter.setData(propertyList);
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);

        }
    }
}
