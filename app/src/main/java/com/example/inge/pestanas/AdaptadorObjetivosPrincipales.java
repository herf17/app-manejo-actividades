package com.example.inge.pestanas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.inge.R;
import com.example.inge.database.model.Actividades;

import java.util.List;

public class AdaptadorObjetivosPrincipales extends RecyclerView.Adapter<AdaptadorObjetivosPrincipales.ObjetivosPrincipalesViewHolder> {
    private List<Actividades> actividades;
    private Context contexto;

    public AdaptadorObjetivosPrincipales(Context context){
        this.contexto = context;
    }
    @NonNull
    @Override
    public ObjetivosPrincipalesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.contexto);
        View view = layoutInflater.inflate(R.layout.contenedor_actividades,parent,false);
        return new ObjetivosPrincipalesViewHolder(view);
    }
    void setObjetivosPrincipales(List<Actividades> actividadesList){
        actividades = actividadesList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ObjetivosPrincipalesViewHolder holder, int position) {
        if (actividades != null){
            Actividades act = actividades.get(position);
            holder.lugar.setText(act.lugar);
            holder.detalle.setText(act.detalle);
            holder.fecha.setText(act.fecha);
        }else {
            holder.lugar.setText("Sin actualizar");
        }
    }

    @Override
    public int getItemCount() {
        if (actividades != null){
            return actividades.size();
        }else {
            return 0;
        }
    }

    public class ObjetivosPrincipalesViewHolder extends RecyclerView.ViewHolder {
        TextView lugar,detalle,fecha;
        public ObjetivosPrincipalesViewHolder(@NonNull View itemView) {
            super(itemView);
            lugar = itemView.findViewById(R.id.actividad_lugar);
            detalle = itemView.findViewById(R.id.actividad_detall);
            fecha = itemView.findViewById(R.id.actividad_fecha);
        }
    }
}
