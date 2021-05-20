package com.example.inge.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inge.database.model.Proyectos;
import com.example.inge.repositorio.TrabajosRepositorio;

import java.util.List;

public class calendarioViewModel extends AndroidViewModel {
    private LiveData<List<Proyectos>> proyectos;
    private TrabajosRepositorio trabajosRepositorio;
    public calendarioViewModel(@NonNull Application application) {
        super(application);
        trabajosRepositorio = new TrabajosRepositorio(application);
        proyectos = trabajosRepositorio.getProyectos();
    }
    public LiveData<List<Proyectos>> getProyectos(){return proyectos;}

}
