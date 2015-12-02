package com.example.marta.lookupscomponentprototype.lookupscomponent.base;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Marta on 30/11/2015.
 */
public abstract class LookupUIBase<T, S> {

    protected View lookupView;
    protected S lookupCallback;
    protected ViewGroup lookupContainer;

    public LookupUIBase(final S lookupCallback) {
        this.lookupCallback = lookupCallback;
    }

    protected abstract View getLookupOf(T entryLookupModel);

    public void showLookup(T entryLookupModel) {
        lookupContainer.addView(getLookupOf(entryLookupModel));
    }

}
