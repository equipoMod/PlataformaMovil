package com.itchihuahuaii.plataformamovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorInicio
        extends RecyclerView.Adapter<AdaptadorInicio.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titulo_carrera;
        public ImageView icono_carrera;

        public ViewHolder(View v) {
            super(v);

            titulo_carrera = (TextView) v.findViewById(R.id.titulo_carrera);
            icono_carrera =(ImageView)v.findViewById(R.id.icono_carrera);
            titulo_carrera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        Fragment fragment = new FragmentSistemas();
                        Bundle bundle = new Bundle();
                        bundle.putString("titulo",titulo_carrera.getText()+"");
                        AppCompatActivity ap = (AppCompatActivity)view.getContext();
                        fragment.setArguments(bundle);
                        FragmentManager fm = ap.getSupportFragmentManager();
                        fm.beginTransaction().replace(R.id.contenedor_principal,fragment).commit();

                }
            });
        }
    }

    public AdaptadorInicio(){

    }

    @Override
    public  int getItemCount(){
        return Curso.CURSOS.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_inicio,viewGroup,false);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(ViewHolder viewHolder,int i){
        Curso item = Curso.CURSOS.get(i);
        viewHolder.titulo_carrera.setText(item.titulo_carrera);
        viewHolder.icono_carrera.setImageResource(item.icono_carrera);


    }


    public static class Curso {
        public String titulo_carrera;
        public int icono_carrera;

        public Curso(String titulo_carrera,int icono_carrera) {
            this.titulo_carrera = titulo_carrera;
            this.icono_carrera=icono_carrera;
        }

        public final static List<Curso> CURSOS = new ArrayList<>();

        static {
            CURSOS.add(new Curso("Ingenieria en Sistemas Computacionales",R.mipmap.ic_ejemplo));
            CURSOS.add(new Curso("Ingenieria en Informatica",R.mipmap.ic_launcher));

        }
    }

}



