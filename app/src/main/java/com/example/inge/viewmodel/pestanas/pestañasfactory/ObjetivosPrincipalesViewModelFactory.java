package com.example.inge.viewmodel.pestanas.pestañasfactory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.inge.viewmodel.pestanas.ObjetivosPrincipalesPViewModel;


public class ObjetivosPrincipalesViewModelFactory implements ViewModelProvider.Factory{
    private Application app;
    private int idppp;
    public ObjetivosPrincipalesViewModelFactory(Application application, int idproy){
        this.app = application;
        this.idppp = idproy;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ObjetivosPrincipalesPViewModel(app,idppp);
    }
}
