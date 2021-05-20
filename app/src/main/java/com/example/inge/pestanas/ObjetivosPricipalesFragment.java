package com.example.inge.pestanas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inge.R;
import com.example.inge.database.model.Actividades;
import com.example.inge.database.model.Proyectos;
import com.example.inge.viewmodel.pestanas.ObjetivosPrincipalesPViewModel;
import com.example.inge.viewmodel.pestanas.pestañasfactory.ObjetivosPrincipalesViewModelFactory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ObjetivosPricipalesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ObjetivosPricipalesFragment extends Fragment {
    private ObjetivosPrincipalesPViewModel objetivosPrincipalesPViewModel;
    private TextView nombre,fecha;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private int mParam1;

    public ObjetivosPricipalesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     *
     * @return A new instance of fragment ObjetivosPricipalesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ObjetivosPricipalesFragment newInstance(int param1) {
        ObjetivosPricipalesFragment fragment = new ObjetivosPricipalesFragment();
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
        View vista = inflater.inflate(R.layout.fragment_objetivos_pricipales, container, false);
        nombre = vista.findViewById(R.id.nombre);
        fecha = vista.findViewById(R.id.fecha);
        RecyclerView recyclerView = (RecyclerView) vista.findViewById(R.id.recyobjetivoprinci);
        final AdaptadorObjetivosPrincipales adaptadorObjetivosPrincipales = new AdaptadorObjetivosPrincipales(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adaptadorObjetivosPrincipales);
        objetivosPrincipalesPViewModel = new ViewModelProvider(this,new ObjetivosPrincipalesViewModelFactory(getActivity().getApplication(),mParam1)).get(ObjetivosPrincipalesPViewModel.class);
        objetivosPrincipalesPViewModel.getActividadesLiveData().observe(getViewLifecycleOwner(), new Observer<List<Actividades>>() {
            @Override
            public void onChanged(List<Actividades> actividades) {
                adaptadorObjetivosPrincipales.setObjetivosPrincipales(actividades);
            }
        });
        objetivosPrincipalesPViewModel.getProyectosLiveData().observe(getViewLifecycleOwner(), new Observer<Proyectos>() {
            @Override
            public void onChanged(Proyectos proyectos) {
                nombre.setText(proyectos.getNombre());
                fecha.setText(proyectos.getFechaInicio());
            }
        });
        return vista;
    }
}