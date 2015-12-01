package com.example.marta.lookupscomponentprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.marta.lookupscomponentprototype.mutientrycomponent.location.LocationLookupsComponent;
import com.example.marta.lookupscomponentprototype.mutientrycomponent.location.LocationModel;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button addLookup;

    private LocationLookupsComponent lookupsComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View container = findViewById(R.id.content_main);

        lookupsComponent = new LocationLookupsComponent(container);

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
