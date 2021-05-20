package com.example.inge.viewmodel.pestanas;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.inge.database.model.Actividades;
import com.example.inge.database.model.Proyectos;
import com.example.inge.repositorio.pestana.ObjetivosPrincipalePRepositorio;

import java.util.List;

public class ObjetivosPrincipalesPViewModel extends AndroidViewModel {
    private ObjetivosPrincipalePRepositorio repositorio;
    private LiveData<List<Actividades>> actividadesLiveData;
    private LiveData<Proyectos> proyectosLiveData;
    public ObjetivosPrincipalesPViewModel(@NonNull Application application, int idproyecto) {
        super(application);
        repositorio = new ObjetivosPrincipalePRepositorio(application,idproyecto);
        actividadesLiveData = repositorio.getActividadesLiveData();
        proyectosLiveData = repositorio.getProyectos();
    }

    public LiveData<List<Actividades>> getActividadesLiveData() {
        return actividadesLiveData;
    }
    public LiveData<Proyectos> getProyectosLiveData(){return proyectosLiveData;}
}
