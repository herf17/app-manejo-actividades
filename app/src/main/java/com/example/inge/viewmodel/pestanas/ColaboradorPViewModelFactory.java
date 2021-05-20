package com.example.inge.viewmodel.pestanas;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ColaboradorPViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private int paranId;

    public ColaboradorPViewModelFactory(Application mApplication, int paranId) {
        this.mApplication = mApplication;
        this.paranId = paranId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ColaboradoresPViewModel(mApplication,paranId);
    }
}



