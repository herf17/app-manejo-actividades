package com.example.inge.repositorio.pestana;

import android.app.Application;

import androidx.lifecycle.LiveData;


import com.example.inge.database.TrabajosDAO;
import com.example.inge.database.TrabajosDatabase;
import com.example.inge.database.model.PestanaColaboradores;

import java.util.List;

public class ColaboradoresPRepositorio {
    private LiveData<List<PestanaColaboradores>> pestanaColaboradores;
    TrabajosDAO trabajosDAO;

    public ColaboradoresPRepositorio(Application application, int id) {
        TrabajosDatabase db = TrabajosDatabase.getInstance(application);
        trabajosDAO = db.trabajosDAO();
        pestanaColaboradores = trabajosDAO.getColaboradoresEnProy(id);
    }

    public LiveData<List<PestanaColaboradores>> getPestanaColaboradores() {
        return pestanaColaboradores;
    }
}
