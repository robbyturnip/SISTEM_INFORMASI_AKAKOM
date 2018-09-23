package com.gmail.robbyturnip333.akakommobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Prodi extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
              View x = inflater.inflate(R.layout.fragment_prodi, null);
        ImageButton ImageButtonTI = (ImageButton) x.findViewById(R.id.btn_ti);
        ImageButton ImageButtonSI = (ImageButton) x.findViewById(R.id.btn_si);
        ImageButton ImageButtonTK = (ImageButton) x.findViewById(R.id.btn_tk);
        ImageButton ImageButtonMI = (ImageButton) x.findViewById(R.id.btn_mi);
        ImageButton ImageButtonKA = (ImageButton) x.findViewById(R.id.btn_ka);
        ImageButtonTI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent= new Intent(context, ProdiTI.class);
                context.startActivity(intent);
            }
        });
        ImageButtonSI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent= new Intent(getActivity(), ProdiSI.class);
                context.startActivity(intent);
            }
        });
        ImageButtonTK.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent= new Intent(getActivity(), ProdiTK.class);
                context.startActivity(intent);
            }
        });
        ImageButtonMI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent= new Intent(getActivity(), ProdiMI.class);
                context.startActivity(intent);
            }
        });
        ImageButtonKA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent= new Intent(getActivity(), ProdiKA.class);
                context.startActivity(intent);
            }
        });

        return x;

    }
    }

