package com.example.marta.lookupscomponentprototype.mutientrycomponent.base;

import android.content.Context;
import android.view.ViewGroup;

/**
 * Created by Marta on 30/11/2015.
 * T - item model
 * S - listener between UI and Presenter
 */
public abstract class LookupBase<T, S> {

    protected Context context;
    protected LookupUIBase<T, S> lookupUI;

    public LookupBase(final Context context) {
        this.context = context;
    }

    protected abstract void setupLookup(T lookupItem, ViewGroup container);

}
