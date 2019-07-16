package com.example.client;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FutureVisit extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.future_visit);

        ListView lvCards = (ListView) findViewById(R.id.list_cards);
        FutureAdapter adapter = new FutureAdapter(this);

        lvCards.setAdapter(adapter);
        adapter.addAll(new FutureModal(R.string.mercury_s, R.string.mercury_e,R.string.mercury_sub ,R.string.mercury),
                new FutureModal( R.string.venus_s, R.string.venus_e, R.string.venus_sub, R.string.venus));
    }
}
