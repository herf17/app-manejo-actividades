package com.example.inge.database.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys ={
        @ForeignKey (entity = Proyectos.class,
                parentColumns = "IdProyectos",
                childColumns = "proyecto"
        ),
        @ForeignKey(
                entity = Usuarios.class,
                parentColumns = "idUsuario",
                childColumns = "usuario"
        )
},indices = {@Index(value = "proyecto"),@Index(value = "usuario")})
public class Actividades {
    @PrimaryKey(autoGenerate = true)
    public int idActividades;

    public String detalle;

    public String fecha;

    public String lugar;

    public int usuario;

    public int proyecto;


    public Actividades(String detalle, String fecha, String lugar, int usuario, int proyecto) {
        this.detalle = detalle;
        this.fecha = fecha;
        this.lugar = lugar;
        this.usuario = usuario;
        this.proyecto = proyecto;
    }

    public void setIdActividades(int idActividades) {
        this.idActividades = idActividades;
    }
}
