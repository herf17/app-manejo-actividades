package com.example.inge.database.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = "idUsuario")})
public class Usuarios {
    @PrimaryKey(autoGenerate = true)
    public int idUsuario;

    public String nombre;

    public String apellido;

    public String clave;


    public Usuarios(String nombre, String apellido, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
}

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
