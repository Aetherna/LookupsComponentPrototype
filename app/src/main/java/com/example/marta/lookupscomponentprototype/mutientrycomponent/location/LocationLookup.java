package com.example.marta.lookupscomponentprototype.mutientrycomponent.location;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.marta.lookupscomponentprototype.mutientrycomponent.base.LookupBase;


/**
 * Created by Marta on 01/12/2015.
 */
public class LocationLookup extends LookupBase<LocationModel, LocationLookupListener> implements LocationLookupListener {

    public LocationLookup(final Context context, final LocationModel item, final ViewGroup componentView) {
        super(context);
        setupLookup(item, componentView);
    }


    @Override
    protected void setupLookup(final LocationModel lookupItem, final ViewGroup container) {
        lookupUI = new LocationLookupUI(context, container, this);
        lookupUI.showLookup(lookupItem);
    }


    @Override
    public void onLocationNameClick(String name) {
        Toast.makeText(context, "Clicked location: " + name, Toast.LENGTH_LONG).show();
    }
}
