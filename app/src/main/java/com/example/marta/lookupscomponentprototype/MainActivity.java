package com.example.marta.lookupscomponentprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.marta.lookupscomponentprototype.entrycomponent.location.LocationEntry;
import com.example.marta.lookupscomponentprototype.lookupscomponent.location.LocationLookupsComponent;
import com.example.marta.lookupscomponentprototype.lookupscomponent.location.LocationModel;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button addLookup;

    private LocationLookupsComponent lookupsComponent;
    private ViewGroup thisViewGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        thisViewGroup = (ViewGroup) findViewById(R.id.content_main);

        setupEntry();
        setupLookups();
        setupButton();

    }

    private void setupEntry() {
        LocationEntry locationEntry = new LocationEntry(this);
        thisViewGroup.addView(locationEntry.getComponentView());
    }

    private void setupLookups() {
        lookupsComponent = new LocationLookupsComponent(this);
        thisViewGroup.addView(lookupsComponent.getComponentView());
    }

    private void setupButton() {
        addLookup = (Button) findViewById(R.id.add_lookup_test);
        addLookup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                lookupsComponent.addItem(getRandom());
            }
        });
    }

    public LocationModel getRandom() {
        LocationModel l = new LocationModel();
        l.setName("name" + new Random().nextInt(100));
        return l;
    }


}
