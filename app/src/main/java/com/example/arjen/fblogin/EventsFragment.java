package com.example.arjen.fblogin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EventsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mov = inflater.inflate(R.layout.fragment_events, container, false);
        ((TextView) mov.findViewById(R.id.textView)).setText("Movies List");
        return mov;
    }



}