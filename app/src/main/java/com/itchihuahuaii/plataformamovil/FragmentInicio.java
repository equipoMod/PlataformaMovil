package com.itchihuahuaii.plataformamovil;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentInicio extends Fragment {



    LinearLayoutManager linearLayout;

    public FragmentInicio() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inicio,container,false);

        RecyclerView reciclador= (RecyclerView)view.findViewById(R.id.reciclador_inicio);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);



        AdaptadorInicio adaptadorInicio = new AdaptadorInicio();
        reciclador.setAdapter(adaptadorInicio);
        return view;
    }

}
