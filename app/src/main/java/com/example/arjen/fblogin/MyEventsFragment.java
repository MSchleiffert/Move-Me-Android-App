package com.example.arjen.fblogin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyEventsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mus = inflater.inflate(R.layout.fragment_myevents, container, false);
        ((TextView)mus.findViewById(R.id.textView)).setText("Music Tracks");
        return mus;
    }}