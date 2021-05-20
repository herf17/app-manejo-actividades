package com.example.inge.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.inge.database.model.Proyectos;
import com.example.inge.repositorio.TrabajosRepositorio;
import com.google.android.material.snackbar.Snackbar;

public class AgregarProyectoViewModel extends AndroidViewModel {
    private TrabajosRepositorio trabajosRepositorio;
    public AgregarProyectoViewModel(@NonNull Application application) {
        super(application);
        trabajosRepositorio = new TrabajosRepositorio(application,0);
    }
    public void insertNewProy(Proyectos proye){
        trabajosRepositorio.insertarNewProy(proye);
    }
    public LiveData<Proyectos> editproy(int idp){
        return trabajosRepositorio.getProy(idp);
    }
}
