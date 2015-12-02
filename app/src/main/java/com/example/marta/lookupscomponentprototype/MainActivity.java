package com.example.marta.lookupscomponentprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.marta.lookupscomponentprototype.entrycomponent.location.LocationEntry;
import com.example.marta.lookupscomponentprototype.lookupscomponent.location.LocationLookupsComponent;
import com.example.marta.lookupscomponentprototype.lookupscomponent.location.LocationModel;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private LocationLookupsComponent lookupsComponent;
    private ViewGroup thisViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        thisViewGroup = (ViewGroup) findViewById(R.id.content_main);

        setupEntry();
        setupLookups();
    }

    private void setupEntry() {
        LocationEntry locationEntry = new LocationEntry(this);
        thisViewGroup.addView(locationEntry.getComponentView());
    }

    private void setupLookups() {
        lookupsComponent = new LocationLookupsComponent(this);
        thisViewGroup.addView(lookupsComponent.getComponentView());
    }

    @OnClick(R.id.add_lookup_test)
    public void addButtonLolLookup() {
        lookupsComponent.addItem(getRandom());
    }

    private LocationModel getRandom() {
        LocationModel l = new LocationModel();
        l.setName("RandomName" + new Random().nextInt(100));
        return l;
    }


}
