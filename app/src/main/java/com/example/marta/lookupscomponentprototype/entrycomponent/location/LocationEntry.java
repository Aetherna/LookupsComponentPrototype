package com.example.marta.lookupscomponentprototype.entrycomponent.location;

import android.content.Context;

import com.example.marta.lookupscomponentprototype.entrycomponent.base.EntryComponent;
import com.example.marta.lookupscomponentprototype.lookupscomponent.location.LocationModel;

/**
 * Created by Aetherna on 2015-12-01.
 */
public class LocationEntry extends EntryComponent<LocationModel> {

    public LocationEntry(Context context) {
        super(context);
    }

    protected LocationModel findSuchItem(String textValue) {

        if (textValue.contains("Error")) {
            return null;
        }
        LocationModel model = new LocationModel();
        model.setName(textValue);

        return model;
    }
}
