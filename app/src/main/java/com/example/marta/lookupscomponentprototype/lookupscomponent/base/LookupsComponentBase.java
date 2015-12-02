package com.example.marta.lookupscomponentprototype.lookupscomponent.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marta.lookupscomponentprototype.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marta on 30/11/2015.
 * T - item model
 * S - listener between UI and Presenter
 */
public abstract class LookupsComponentBase<T, S> {

    protected Context context;
    protected ViewGroup componentView;

    public LookupsComponentBase(Context context) {
        this.context = context;
    }

    protected List<LookupBase<T, S>> lookups = new ArrayList<>();

    protected abstract LookupBase getLookupFrom(T item);

    public void addItem(T item){
       lookups.add(getLookupFrom(item));
    }

    public View getComponentView() {
        if (componentView == null) {
            componentView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.lookups_container, null);
        }
        return componentView;
    }
}
