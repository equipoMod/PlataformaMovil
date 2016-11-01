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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class FragmentSistemas extends Fragment {


    public TextView texto;
    public ImageView imageView;
    LinearLayoutManager linearLayout;


    public FragmentSistemas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View view = inflater.inflate(R.layout.fragment_carrera,container,false);
        texto=(TextView)view.findViewById(R.id.texto_experimento);
        imageView=(ImageView) view.findViewById(R.id.icono_experimento);
        texto.setText(""+bundle.getString("titulo"));
        /*RecyclerView reciclador= (RecyclerView)view.findViewById(R.id.reciclador_inicio);
        linearLayout = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(linearLayout);

        AdaptadorInicio adaptadorInicio = new AdaptadorInicio();
        reciclador.setAdapter(adaptadorInicio);*/
        return view;
    }
}
