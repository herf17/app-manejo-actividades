package com.example.inge;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.inge.database.model.Proyectos;
import com.example.inge.viewmodel.calendarioViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calendario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calendario extends Fragment implements AdapterTablero.click {
    public RecyclerView recycler;
    public calendarioViewModel calendarioViewModel;
    public AdapterTablero adapterTablero;
    List<Proyectos> proy;
    private static final String TAG = "Calendario";
    FloatingActionButton fab;
    int iduser;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private int mParam1;

    public calendario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     *
     * @return A new instance of fragment calendario.
     */
    // TODO: Rename and change types and number of parameters
    public static calendario newInstance(int param1) {
        calendario fragment = new calendario();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_calendario, container, false);
        recycler = (RecyclerView) vista.findViewById(R.id.recyclervius);
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapterTablero = new AdapterTablero(getContext(), this);
        recycler.setAdapter(adapterTablero);
        calendarioViewModel = new ViewModelProvider(this).get(calendarioViewModel.class);
        calendarioViewModel.getProyectos().observe(getViewLifecycleOwner(), new Observer<List<Proyectos>>() {
            @Override
            public void onChanged(List<Proyectos> trabajosemodels) {
                proy = trabajosemodels;
                adapterTablero.setTrabajos(trabajosemodels);
            }
        });

        fab = vista.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.agregarPoyecto);
            }
        });

        /*Para esconde el boton de agregar proyecto por si el usuario no es colaborador
        if (calendarioViewModel.id == 1 ||calendarioViewModel.id ==2){
            fab.setVisibility(View.VISIBLE);
        }else{
            fab.setVisibility(View.INVISIBLE);
        }*/
        return vista;
    }


    @Override
    public void clicklisten(int posicion) {
        Proyectos proyectos = proy.get(posicion);
        int idProy = proyectos.IdProyectos;
        Log.i(TAG, "Id Proyecto: " + idProy);
        NavGraphDirections.ActionGlobalTrabajoSeleccionado accionProyecto = calendarioDirections.actionGlobalTrabajoSeleccionado(idProy);
        NavHostFragment.findNavController(this).navigate(accionProyecto);
        //NavGraphDirections.ActionGlobalTrabajoSeleccionado action = NavGraphDirections.actionGlobalTrabajoSeleccionado(trabajos[posicion]);
        /*NavGraphDirections.ActionGlobalTrabajoSeleccionado actionGlobalTrabajoSeleccionado = calendarioDirections.actionGlobalTrabajoSeleccionado();
        actionGlobalTrabajoSeleccionado.setIdentificadortrabajo();*/
        //NavHostFragment.findNavController(this).navigate(actionGlobalTrabajoSeleccionado);
        //Toast.makeText(getContext(),trabajos[posicion],Toast.LENGTH_SHORT).show();
    }
}