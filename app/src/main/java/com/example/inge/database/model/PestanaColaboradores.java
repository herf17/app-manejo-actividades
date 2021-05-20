package com.example.inge.database.model;

import androidx.room.ColumnInfo;

public class PestanaColaboradores {
    @ColumnInfo(name = "nombre")
    public String Nombre;
    @ColumnInfo(name = "apellido")
    public String Apellido;

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }
}
