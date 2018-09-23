package com.gmail.robbyturnip333.akakommobile;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class KontakAka extends Fragment {

    Context context;
    public KontakAka() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View x = inflater.inflate(R.layout.fragment_kontak_aka, null);

        ImageButton view_maps = (ImageButton) x.findViewById(R.id.view_maps);
        view_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(getActivity(), MapsAka.class);
                context.startActivity(intent);
            }
        });
        return x;

    }

}
