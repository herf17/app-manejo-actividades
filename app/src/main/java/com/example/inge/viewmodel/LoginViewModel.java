package com.example.inge.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginViewModel extends AndroidViewModel {
    public enum EstadoAutenticacion {
        AUTENTICADO,
        SINAUTENTICR,
        AUTENTICACION_INVALIDA
    }
    private static final String TAG = "LoginViewModel";
    public MutableLiveData<EstadoAutenticacion> estado;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public int iduser;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        sharedPreferences = application.getSharedPreferences("sesion", Context.MODE_PRIVATE);

    }

    public void autenticar(String username, String contraseña){
        if (username.equals("utp") && contraseña.equals("1234")){

            //Se guarda el id del colaborador que inicio sesion
            editor = sharedPreferences.edit();
            editor.putInt("user",5);
            editor.apply();
            estado.setValue(EstadoAutenticacion.AUTENTICADO);
        } else if (username.equals("administrador") && contraseña.equals("123")) {
            editor = sharedPreferences.edit();
            editor.putInt("user",1);
            editor.apply();
            estado.setValue(EstadoAutenticacion.AUTENTICADO);
        } else {
            estado.setValue(EstadoAutenticacion.AUTENTICACION_INVALIDA);
        }
    }
    public LiveData<EstadoAutenticacion> getEstado() {
        if (estado == null){
            estado = new MutableLiveData<EstadoAutenticacion>();
            if (comprobarEstado()){
                estado.setValue(EstadoAutenticacion.AUTENTICADO);
                Log.i(TAG,"SI ESTA AUTENTICADO"+iduser);
            }else{
                estado.setValue(EstadoAutenticacion.SINAUTENTICR);
            }
        }
        if (comprobarEstado()){
            estado.setValue(EstadoAutenticacion.AUTENTICADO);
            Log.i(TAG,"SI ESTA AUTENTICADO"+iduser);
        }else{
            estado.setValue(EstadoAutenticacion.SINAUTENTICR);
        }
        return estado;
    }
    private boolean comprobarEstado(){
        iduser = sharedPreferences.getInt("user",0);
        return iduser != 0;
    }
    public void actualizar(){
        if(editor == null){
            editor = sharedPreferences.edit();
        }
        editor.putInt("user",0);
        editor.apply();
        estado.setValue(EstadoAutenticacion.SINAUTENTICR);
    }
}
