package com.example.inge.repositorio;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.example.inge.database.TrabajosDAO;
import com.example.inge.database.TrabajosDatabase;
import com.example.inge.database.model.Actividades;
import com.example.inge.database.model.Proyectos;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TrabajosRepositorio {
    private TrabajosDAO trabajosDAO;
    private LiveData<List<Proyectos>> proyectos;
    private LiveData<Proyectos> proyectosLiveData;

    public TrabajosRepositorio(Application application){
        TrabajosDatabase db = TrabajosDatabase.getInstance(application);
        trabajosDAO = db.trabajosDAO();
        proyectos = trabajosDAO.VerProyectos();
    }
    public TrabajosRepositorio(Application app, int i){
        TrabajosDatabase db = TrabajosDatabase.getInstance(app);
        trabajosDAO = db.trabajosDAO();
    }
    public LiveData<List<Proyectos>> getProyectos(){return proyectos;}
    public void insertarNewProy(final Proyectos proyec){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                trabajosDAO.insertarProyecto(proyec);
            }
        });
    }
    public  void insertarNeAct(final Actividades actividades){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                trabajosDAO.insertarActividades(actividades);
            }
        });
    }
    public LiveData<Proyectos> getProy(int id){
        proyectosLiveData = trabajosDAO.getProyectoId(id);
        return proyectosLiveData;
    }
}
