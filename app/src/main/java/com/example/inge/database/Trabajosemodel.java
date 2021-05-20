package com.example.inge.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trabajos")
public class Trabajosemodel {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String detallestrabajos;
    public String colaboradores;
    public String materiales;

    public Trabajosemodel(String detallestrabajos, String colaboradores, String materiales) {
        this.detallestrabajos = detallestrabajos;
        this.colaboradores = colaboradores;
        this.materiales = materiales;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDetallestrabajos() {
        return detallestrabajos;
    }

    public String getColaboradores() {
        return colaboradores;
    }

    public String getMateriales() {
        return materiales;
    }
}
