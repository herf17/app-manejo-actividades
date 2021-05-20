package com.example.inge.viewmodel.pestanas;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.inge.database.model.PestanaColaboradores;
import com.example.inge.repositorio.pestana.ColaboradoresPRepositorio;

import java.util.List;

public class ColaboradoresPViewModel extends AndroidViewModel {
    private ColaboradoresPRepositorio colaborepo;
    private LiveData<List<PestanaColaboradores>> pestanaColaboradoresList;
    public ColaboradoresPViewModel(@NonNull Application application, int id) {
        super(application);
        colaborepo = new ColaboradoresPRepositorio(application,id);
        pestanaColaboradoresList = colaborepo.getPestanaColaboradores();
    }

    public LiveData<List<PestanaColaboradores>> getPestanaColaboradoresList() {
        return pestanaColaboradoresList;
    }
}
