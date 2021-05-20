package com.example.inge.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.inge.database.model.Actividades;
import com.example.inge.database.model.PestanaColaboradores;
import com.example.inge.database.model.Proyectos;
import com.example.inge.database.model.Usuarios;

import java.util.List;

@Dao
public interface TrabajosDAO {

    @Query("SELECT * FROM usuarios")
    LiveData<List<Usuarios>> VerUsuarios();

    @Query("SELECT * FROM Proyectos")
    LiveData<List<Proyectos>> VerProyectos();

    @Query("SELECT * FROM actividades")
    LiveData<List<Actividades>> VerActividades();

    @Query("SELECT * FROM Actividades WHERE proyecto = :idProyect")
    LiveData<List<Actividades>> getActividadProyecto(int idProyect);

    @Query("SELECT * FROM proyectos WHERE IdProyectos = :idp")
    LiveData<Proyectos> getProyectoId(int idp);
    @Query("SELECT * FROM proyectos WHERE IdProyectos = :idp")
    Proyectos getProy(int idp);

    @Query("SELECT DISTINCT usuarios.nombre, usuarios.apellido FROM usuarios " +
            "INNER JOIN Actividades ON Actividades.usuario = usuarios.idUsuario " +
            "INNER JOIN proyectos ON proyectos.IdProyectos = Actividades.proyecto " +
            "WHERE proyectos.IdProyectos = :idproy")
    LiveData<List<PestanaColaboradores>> getColaboradoresEnProy(int idproy);

    @Insert
    void insertar(Usuarios usuarios);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarProyecto(Proyectos proyectos);

    @Insert
    void insertarActividades(Actividades actividades);
}
