package com.example.marta.lookupscomponentprototype.lookupscomponent.location;

import android.content.Context;

import com.example.marta.lookupscomponentprototype.lookupscomponent.base.LookupsComponentBase;

import de.greenrobot.event.EventBus;


/**
 * Created by Marta on 30/11/2015.
 */
public class LocationLookupsComponent extends LookupsComponentBase<LocationModel, LocationLookupListener> {

    public LocationLookupsComponent(Context context) {
        super(context);
        EventBus.getDefault().register(this);
    }

    @Override
    protected LocationLookup getLookupFrom(final LocationModel item) {
        LocationLookup lookup = new LocationLookup(context, item, componentView);
        return lookup;
    }


    public void onEvent(LocationModel event) {
        addItem(event);
    }

}
