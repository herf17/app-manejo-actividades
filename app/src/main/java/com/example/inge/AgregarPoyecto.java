package com.example.inge;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.inge.database.model.Proyectos;
import com.example.inge.viewmodel.AgregarProyectoViewModel;

import java.util.IllegalFormatCodePointException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarPoyecto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarPoyecto extends Fragment {
    private EditText titulo,fecha;
    private Button boton;
    private AgregarProyectoViewModel agreproyViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private int mParam1;


    public AgregarPoyecto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     *
     * @return A new instance of fragment AgregarPoyecto.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarPoyecto newInstance(String param1) {
        AgregarPoyecto fragment = new AgregarPoyecto();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistas = inflater.inflate(R.layout.fragment_agregar_poyecto, container, false);
        titulo = vistas.findViewById(R.id.proyectoNom);
        fecha = vistas.findViewById(R.id.proyectoFecha);
        boton = vistas.findViewById(R.id.proyenvinuevo);
        agreproyViewModel = new ViewModelProvider(this).get(AgregarProyectoViewModel.class);
        if (getArguments() != null){
            agreproyViewModel.editproy(mParam1).observe(getViewLifecycleOwner(), new Observer<Proyectos>() {
                @Override
                public void onChanged(Proyectos proyectos) {
                    titulo.setText(proyectos.getNombre());
                    fecha.setText(proyectos.getFechaInicio());
                }
            });
        }
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final NavController controller = Navigation.findNavController(view);
                if (getArguments() != null){
                    agreproyViewModel.insertNewProy(new Proyectos(mParam1,titulo.getText().toString(),fecha.getText().toString()));
                }else
                agreproyViewModel.insertNewProy(new Proyectos(titulo.getText().toString(),fecha.getText().toString()));
                controller.popBackStack();
            }
        });
        return vistas;
    }
}