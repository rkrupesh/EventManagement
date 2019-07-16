package com.example.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button newVisit , futureVisit, pastVisit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        newVisit = (Button) findViewById(R.id.newVisit);
        futureVisit = (Button) findViewById(R.id.futureVisit);
        pastVisit = (Button) findViewById(R.id.pastVisit);
        newVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(SecondActivity.this,NewVisit.class);
                startActivity(i);
            }
        });

        futureVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(getApplicationContext(),"It will come in upcoming builds..",Toast.LENGTH_LONG).show();
                Intent i = new Intent(SecondActivity.this,FutureVisit.class);
                startActivity(i);
            }
        });

        pastVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"It will come in Upcomming builds..",Toast.LENGTH_LONG).show();
            }
        });
    }
}
