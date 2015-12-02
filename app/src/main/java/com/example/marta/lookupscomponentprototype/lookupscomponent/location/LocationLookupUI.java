package com.example.marta.lookupscomponentprototype.lookupscomponent.location;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marta.lookupscomponentprototype.R;

import com.example.marta.lookupscomponentprototype.lookupscomponent.base.LookupUIBase;


/**
 * Created by Marta on 30/11/2015.
 */
public class LocationLookupUI extends LookupUIBase<LocationModel, LocationLookupListener> {

    protected Context context;

    public LocationLookupUI(final Context context, final ViewGroup container, final LocationLookupListener locationLookupListener) {
        super(locationLookupListener);
        this.context = context;
        this.lookupContainer = container;
    }

    @Override
    protected View getLookupOf(final LocationModel model) {
        this.lookupView = LayoutInflater.from(context).inflate(R.layout.entry_lookup, null);

        TextView locationName = (TextView) lookupView.findViewById(R.id.entry_lookup_item_name);
        locationName.setText(model.getName());
        locationName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                lookupCallback.onLocationNameClick(model.getName());
            }
        });
        return lookupView;
    }
}
