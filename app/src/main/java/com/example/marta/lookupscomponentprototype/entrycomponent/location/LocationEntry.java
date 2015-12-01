package com.example.marta.lookupscomponentprototype.entrycomponent.location;

import android.content.Context;

import com.example.marta.lookupscomponentprototype.entrycomponent.base.EntryComponent;
import com.example.marta.lookupscomponentprototype.mutientrycomponent.location.LocationModel;

/**
 * Created by Aetherna on 2015-12-01.
 */
public class LocationEntry extends EntryComponent<LocationModel> {

    public LocationEntry(Context context) {
        super(context);
    }

    @Override // should be async work somewhere here
    protected LocationModel findSuchItem(String textValue) {

        if (textValue.contains("Error")) {
            return null;
        }
        LocationModel model = new LocationModel();
        model.setName(textValue);

        return model;
    }
}
