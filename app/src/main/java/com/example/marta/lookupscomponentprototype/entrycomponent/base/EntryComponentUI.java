package com.example.marta.lookupscomponentprototype.entrycomponent.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.marta.lookupscomponentprototype.R;
import com.example.marta.lookupscomponentprototype.entrycomponent.base.EntryComponentUIListener;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Aetherna on 2015-12-01.
 */
public class EntryComponentUI {

    private final View view;
    protected Context context;
    protected EntryComponentUIListener uiListener;

    @Bind(R.id.text_entry)
    EditText textEntry;
    @Bind(R.id.scan_entry)
    Button cameraButton;
    @Bind(R.id.search_entry)
    Button searchButton;
    @Bind(R.id.entry_validationInProgress)
    ProgressBar validationInProgress;

    public EntryComponentUI(Context context, EntryComponentUIListener uiListener) {
        this.context = context;
        this.uiListener = uiListener;
        this.view = LayoutInflater.from(context).inflate(R.layout.entry_component, null);

        ButterKnife.bind(this, view);

        setupTextEntry();
    }

    private void setupTextEntry() {

        textEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    return;
                }
                uiListener.onTextEnteredSomehow(editable.toString());
            }
        });

    }

    @OnClick(R.id.scan_entry)
    public void sendScannedValue() {
        uiListener.onTextEnteredSomehow("ScannedValue " + new Random().nextInt(10));
    }

    @OnClick(R.id.search_entry)
    public void sendSearchedValue() {
        uiListener.onTextEnteredSomehow("SearchedValue " + new Random().nextInt(10));
    }

    void showValidationInProgress() {
        validationInProgress.setVisibility(View.VISIBLE);
    }

    void hideValidation() {
        validationInProgress.setVisibility(View.GONE);
    }

    void showValidationError(String error) {
        textEntry.setError(error);
    }

    public View getView() {
        return view;
    }
}
