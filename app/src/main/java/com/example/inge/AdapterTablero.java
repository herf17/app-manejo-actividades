package com.example.inge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inge.database.model.Proyectos;

import java.util.List;

public class AdapterTablero extends RecyclerView.Adapter<AdapterTablero.TableroViewHolder> {
    private Context context;
    private click listener;
    public List<Proyectos> trabajosemodelList;

    public AdapterTablero(Context context,click clickL) {
        this.context = context;
        this.listener = clickL;
    }

    @NonNull
    @Override
    public TableroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View view = layoutInflater.inflate(R.layout.contenedor_tablero,parent,false);
        return new TableroViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TableroViewHolder holder, int position) {
        if (trabajosemodelList != null){
            Proyectos trab = trabajosemodelList.get(position);
            holder.textView.setText(trab.getNombre());
            holder.fecha.setText(trab.getFechaInicio());
        }else{
            holder.textView.setText("sin actualizar");
        }
    }

    void setTrabajos(List<Proyectos> trabajos){
        trabajosemodelList = trabajos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (trabajosemodelList != null){
            return trabajosemodelList.size();
        } else return 0;
    }

    public class TableroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView, fecha;
        click click;

        public TableroViewHolder(@NonNull View itemView,click cl) {
            super(itemView);
            textView = itemView.findViewById(R.id.trab);
            fecha = itemView.findViewById(R.id.fecha);
            this.click = cl;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            click.clicklisten(getAdapterPosition());
        }
    }

    public interface click{
        void clicklisten(int posicion);
    }

}
