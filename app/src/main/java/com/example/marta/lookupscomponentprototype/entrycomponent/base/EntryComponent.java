package com.example.marta.lookupscomponentprototype.entrycomponent.base;

import android.content.Context;
import android.view.View;

import java.util.concurrent.TimeUnit;

import de.greenrobot.event.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Aetherna on 2015-12-01.
 */
public abstract class EntryComponent<T> implements EntryComponentUIListener {

    EntryComponentUI entryComponentUI;
    private Subscription ob;

    public EntryComponent(Context context) {
        entryComponentUI = new EntryComponentUI(context, this);
    }

    public void onTextEnteredSomehow(String textValue) {

        entryComponentUI.showValidationInProgress();

        if (ob != null && !ob.isUnsubscribed()) {
            ob.unsubscribe();
        }
        ob = Observable.just(findSuchItem(textValue))
                .delay(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<T>() {
                    @Override
                    public void call(T item) {

                        if (validateItem(item)) {
                            EventBus.getDefault().post(item);
                        }
                    }
                });
    }

    private boolean validateItem(final T item) {
        boolean result = false;

        if (item != null) {
            result = true;
        } else {
            entryComponentUI.showValidationError("No such item :<");
        }
        entryComponentUI.hideValidation();
        return result;
    }

    protected abstract T findSuchItem(String textValue);


    public View getComponentView() {
        return entryComponentUI.getView();
    }
}
