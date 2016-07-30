package com.example.lucas.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        getSupportActionBar().setTitle(getString(getIntent().getIntExtra("tipo", 0)));

        if (savedInstanceState == null) {
            FragmentAnime frag = new FragmentAnime();
            frag.setArguments(getIntent().getExtras());
//            getSupportFragmentManager().beginTransaction().add(R.id.)
        }
    }
}
