package com.itchihuahuaii.plataformamovil;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class AdaptadorCursos
        extends RecyclerView.Adapter<AdaptadorCursos.ViewHolder> {



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titulo_curso;
        public TextView tareas_pendientes;
        public TextView nombre_profesor;
        public ImageView curso_icono;

        public ViewHolder(View v) {
            super(v);
            titulo_curso = (TextView) v.findViewById(R.id.curso_titulo);
            tareas_pendientes = (TextView) v.findViewById(R.id.curso_tareas_pendientes);
            nombre_profesor = (TextView) v.findViewById(R.id.curso_nombre_profesor);
            curso_icono =(ImageView)v.findViewById(R.id.curso_icono);
            titulo_curso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getAdapterPosition();
                    Toast.makeText(view.getContext(),"Presionaste el "+(getAdapterPosition()+1)+" elemento",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public AdaptadorCursos(){

    }
    @Override
    public  int getItemCount(){
        return Curso.CURSOS.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_cursos,viewGroup,false);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(ViewHolder viewHolder,int i){
        Curso item = Curso.CURSOS.get(i);
        viewHolder.titulo_curso.setText(item.titulo_curso);
        viewHolder.tareas_pendientes.setText(item.tareas_pendientes);
        viewHolder.nombre_profesor.setText(item.nombre_profesor);
        viewHolder.curso_icono.setImageResource(item.icono_curso);


    }


    public static class Curso {
        public String titulo_curso;
        public String tareas_pendientes;
        public String nombre_profesor;
        public int icono_curso;

        public Curso(String titulo_curso, String tareas_pendientes,String nombre_profesor,int icono_curso) {
            this.titulo_curso = titulo_curso;
            this.tareas_pendientes = tareas_pendientes;
            this.nombre_profesor=nombre_profesor;
            this.icono_curso=icono_curso;
        }

        public final static List<Curso> CURSOS = new ArrayList<>();

        static {
            CURSOS.add(new Curso("Sistemas Operativos Moviles","Tienes 2 tareas","Alonso",R.mipmap.ic_app));
            CURSOS.add(new Curso("Base de datos","Tienes 1 tarea","Ignacio",R.mipmap.ic_app));
            CURSOS.add(new Curso("Redes de computadoras","No tienes tareas","Angelica",R.mipmap.ic_app));

        }
    }

}


