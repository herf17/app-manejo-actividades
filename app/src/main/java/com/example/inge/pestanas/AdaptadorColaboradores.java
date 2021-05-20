package com.example.inge.pestanas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.inge.R;
import com.example.inge.database.model.PestanaColaboradores;

import java.util.List;

public class AdaptadorColaboradores extends RecyclerView.Adapter<AdaptadorColaboradores.ColaboradorViewHolder> {
    private Context context;
    private List<PestanaColaboradores> pestanaColaboradores;

    public AdaptadorColaboradores(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ColaboradorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View vista = layoutInflater.inflate(R.layout.pestana_colaborador,parent,false);
        return new ColaboradorViewHolder(vista);
    }

    void setColaboradoresL(List<PestanaColaboradores> colaboradores){
        pestanaColaboradores = colaboradores;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ColaboradorViewHolder holder, int position) {
        if (pestanaColaboradores != null){
            PestanaColaboradores trab = pestanaColaboradores.get(position);
            holder.textView.setText(trab.getNombre());
            holder.textView2.setText(trab.getApellido());
        }else{
            holder.textView.setText("sin actualizar");
        }
    }

    @Override
    public int getItemCount() {
        if (pestanaColaboradores != null){
            return pestanaColaboradores.size();
        }else {
            return 0;
        }
    }

    public class ColaboradorViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView2;
        public ColaboradorViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }

}
