package com.example.lucas.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentAnime extends Fragment implements View.OnClickListener {

    Button button;

    public FragmentAnime() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_anime, container, false);

        Button b = (Button) v.findViewById(R.id.button);
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            Snackbar.make(v, "Funciona ae ... Birr", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        }
    }
}
