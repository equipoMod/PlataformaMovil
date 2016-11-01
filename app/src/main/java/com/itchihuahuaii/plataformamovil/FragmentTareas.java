package com.itchihuahuaii.plataformamovil;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FragmentTareas extends Fragment {

    private GridLayoutManager linearLayout;

    private ImageView imageView;
    private TextView textView;

    public FragmentTareas() {
        // Required empty public constructor
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grupo_items,container,false);


        RecyclerView reciclador= (RecyclerView)view.findViewById(R.id.reciclador);
        linearLayout = new GridLayoutManager(getActivity(),2);
        reciclador.setLayoutManager(linearLayout);

        AdaptadorCursos adaptadorCursos = new AdaptadorCursos();
        reciclador.setAdapter(adaptadorCursos);
        return view;

    }
}