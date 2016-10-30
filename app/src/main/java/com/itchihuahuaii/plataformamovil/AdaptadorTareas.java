package com.itchihuahuaii.plataformamovil;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario1 on 10/29/2016.
 */
public class AdaptadorTareas
        extends RecyclerView.Adapter<AdaptadorTareas.ViewHolder> {



    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tarea;
        TextView tiempo;

        public ViewHolder(View v) {
            super(v);
            tarea = (TextView) v.findViewById(R.id.tarea_titulo);
            tiempo = (TextView) v.findViewById(R.id.tarea_tiempo);
            tarea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getAdapterPosition();
                    Toast.makeText(view.getContext(),"Presionaste el "+(getAdapterPosition()+1)+" elemento",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
        public AdaptadorTareas(){

        }
    @Override
        public  int getItemCount(){
            return Tarea.TAREAS.size();
        }

@Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_lista_tareas,viewGroup,false);
            return new ViewHolder(v);
        }

        public void onBindViewHolder(ViewHolder viewHolder,int i){
            Tarea item = Tarea.TAREAS.get(i);
            viewHolder.tarea.setText(item.titulo);
            viewHolder.tiempo.setText(item.tiempo);
        }


    public static class Tarea {
        public String titulo;
        public String tiempo;

        public Tarea(String titulo, String tiempo) {
            this.titulo = titulo;
            this.tiempo = tiempo;
        }

        public final static List<Tarea> TAREAS = new ArrayList<Tarea>();

        static {
            TAREAS.add(new Tarea("Documentacion Practica 1","Tiempo restante 2 horas"));
            TAREAS.add(new Tarea("Documentacion Practica 3","Tiempo restante 1 horas"));
            TAREAS.add(new Tarea("Documentacion Practica Wifi","Tiempo restante 5 horas"));

        }
    }

}


