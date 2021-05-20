package com.example.inge.repositorio.pestana;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.inge.database.TrabajosDAO;
import com.example.inge.database.TrabajosDatabase;
import com.example.inge.database.model.Actividades;
import com.example.inge.database.model.Proyectos;

import java.util.List;

public class ObjetivosPrincipalePRepositorio {
    private LiveData<List<Actividades>> actividadesLiveData;
    private LiveData<Proyectos> proyectos;
    private TrabajosDAO trabajosDao;

    public ObjetivosPrincipalePRepositorio(Application application, int idP){
        TrabajosDatabase db = TrabajosDatabase.getInstance(application);
        trabajosDao = db.trabajosDAO();
        actividadesLiveData = trabajosDao.getActividadProyecto(idP);
        proyectos = trabajosDao.getProyectoId(idP);
    }

    public LiveData<List<Actividades>> getActividadesLiveData() {
        return actividadesLiveData;
    }
    public LiveData<Proyectos> getProyectos(){return proyectos;}
}
