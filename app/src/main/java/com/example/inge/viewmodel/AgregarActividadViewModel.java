package com.example.inge.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inge.database.model.Actividades;
import com.example.inge.repositorio.TrabajosRepositorio;

public class AgregarActividadViewModel extends AndroidViewModel {
    TrabajosRepositorio trabajosRepositorio;
    private MutableLiveData<String> hora;
    int idtr;
    public AgregarActividadViewModel(@NonNull Application application) {
        super(application);
        trabajosRepositorio = new TrabajosRepositorio(application,0);
    }

    public void insertarNewActi(String detalle, String fecha, String lugar, int proy){
        trabajosRepositorio.insertarNeAct(new Actividades(detalle,fecha,lugar,idtr,proy));
    }

    public LiveData<String> getHora() {
        if (hora == null){
            hora = new MutableLiveData<>();
        }
        return hora;
    }

    public void setIdtr(String idtr) {
        switch (idtr){
            case "Benjamin Quintero":
                this.idtr = 1;
                break;
            case "Fermín Quintero":
                this.idtr = 3;
                break;
            case "Alexander Batita":
                this.idtr = 4;
                break;
            case "Manuel Batista":
                this.idtr = 5;
                break;
            case "Israel Valdéz":
                this.idtr = 6;
                break;
            case "Toni Pérez":
                this.idtr = 7;
                break;
            case "Ricardo Gomez":
                this.idtr = 8;
                break;
        }
    }

    public int getIdtr() {
        return idtr;
    }

    public void setHora(String i) {
        hora.setValue(i);
    }
}
