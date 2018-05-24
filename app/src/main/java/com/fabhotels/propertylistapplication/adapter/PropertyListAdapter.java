package com.fabhotels.propertylistapplication.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.fabhotels.propertylistapplication.R;
import com.fabhotels.propertylistapplication.model.PropertyListItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *  Created by Niharika on 24-05-2018.
 * A custom adapter to use with the RecyclerView widget.
 */
public class PropertyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<PropertyListItem> modelList = new ArrayList<>();


    public PropertyListAdapter(Context context) {
        this.mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_property_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final PropertyListItem model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.itemTxtName.setText(model.getName());
            genericViewHolder.itemTxtCity.setText(model.getLandmark());


        }
    }


    @Override
    public int getItemCount() {

        return modelList.size();
    }


    private PropertyListItem getItem(int position) {
        return modelList.get(position);
    }

    public void setData(List<PropertyListItem> propertyList) {
        modelList.clear();
        modelList.addAll(propertyList);
        Handler handler = new Handler();
        final Runnable r = this::notifyDataSetChanged;
        handler.post(r);
    }


    class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.item_txt_name)
        TextView itemTxtName;
        @BindView(R.id.item_txt_city)
        TextView itemTxtCity;

        ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

