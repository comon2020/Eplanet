package com.example.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

// 주희 : 행성리스트 액티비티
public class PlanetListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        ImageView planet1 = (ImageView) findViewById(R.id.planet1);
        planet1.setImageResource(R.drawable.planet1);

        planet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlanetActivity1.class);
                startActivity(intent);
            }
        });

        ImageView planet2 = (ImageView) findViewById(R.id.planet2);
        planet2.setImageResource(R.drawable.planet2);

        ImageView planet3 = (ImageView) findViewById(R.id.planet3);
        planet3.setImageResource(R.drawable.planet3);

        ImageView dev = (ImageView) findViewById(R.id.dev);
        dev.setImageResource(R.drawable.planet_devs);

    }



}
