package com.example.inge.database.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = "IdProyectos")})
public class Proyectos {
    @PrimaryKey(autoGenerate = true)
    public int IdProyectos;

    public String nombre;

    public String fechaInicio;
    @Ignore
    public Proyectos(int IdProyectos,String nombre, String fechaInicio){
        this.IdProyectos = IdProyectos;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
    }
    public Proyectos(String nombre, String fechaInicio) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
    }

    public void setIdProyectos(int idProyectos) {
        IdProyectos = idProyectos;
    }

    public int getIdProyectos() {
        return IdProyectos;
    }

    public String getNombre() {
        return nombre;
    }


    public String getFechaInicio() {
        return fechaInicio;
    }

}
