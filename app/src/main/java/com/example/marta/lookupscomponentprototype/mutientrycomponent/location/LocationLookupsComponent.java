package com.example.marta.lookupscomponentprototype.mutientrycomponent.location;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.marta.lookupscomponentprototype.R;
import com.example.marta.lookupscomponentprototype.mutientrycomponent.base.LookupsComponentBase;


/**
 * Created by Marta on 30/11/2015.
 */
public class LocationLookupsComponent extends LookupsComponentBase<LocationModel, LocationLookupListener> {

    private Context context;

    private ViewGroup componentView;

    public LocationLookupsComponent(final View containerView) {
        this.context = containerView.getContext();
        componentView = (ViewGroup) containerView.findViewById(R.id.LocationLookupsContainer);
    }

    @Override
    public void addItem(final LocationModel item) {
        LocationLookup lookup = new LocationLookup(context, item, componentView);
        lookups.add(lookup);
    }
}
