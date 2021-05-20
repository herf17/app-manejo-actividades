package com.example.inge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.calendario,R.id.inicio,R.id.notificaciones)
                .build();
        final MaterialToolbar toolbar = findViewById(R.id.barraarriba);

        final BottomNavigationView barra_inferi = findViewById(R.id.botones_infer);
        NavController control_navegador = Navigation.findNavController(this, R.id.fragment2);
        control_navegador.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.login){
                    barra_inferi.setVisibility(View.GONE);
                    toolbar.setVisibility(View.GONE);
                }else if(destination.getId() == R.id.trabajo_seleccionado){
                    toolbar.setVisibility(View.GONE);
                }else {
                    barra_inferi.setVisibility(View.VISIBLE);
                    toolbar.setVisibility(View.VISIBLE);
                }
            }
        });
        //NavigationUI.setupActionBarWithNavController(this,control_navegador,appBarConfiguration);
        NavigationUI.setupWithNavController(barra_inferi,control_navegador);
        NavigationUI.setupWithNavController(toolbar,control_navegador,appBarConfiguration);
    }

}