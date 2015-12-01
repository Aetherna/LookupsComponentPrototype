package com.example.marta.lookupscomponentprototype.mutientrycomponent.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marta on 30/11/2015.
 * T - item model
 * S - listener between UI and Presenter
 */
public abstract class LookupsComponentBase<T, S> {

    protected List<LookupBase<T, S>> lookups = new ArrayList<>();

    protected abstract void addItem(T item);

}
