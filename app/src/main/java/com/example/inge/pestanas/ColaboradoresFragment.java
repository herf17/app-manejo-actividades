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

import com.example.inge.R;
import com.example.inge.database.model.PestanaColaboradores;
import com.example.inge.viewmodel.pestanas.ColaboradorPViewModelFactory;
import com.example.inge.viewmodel.pestanas.ColaboradoresPViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColaboradoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColaboradoresFragment extends Fragment {
    ColaboradoresPViewModel colaboradoresPViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private int mParam1;

    public ColaboradoresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     *
     * @return A new instance of fragment ColaboradoresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ColaboradoresFragment newInstance(int param1) {
        ColaboradoresFragment fragment = new ColaboradoresFragment();
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
        View vista = inflater.inflate(R.layout.fragment_colaboradores, container, false);
        RecyclerView recyclerColab = (RecyclerView) vista.findViewById(R.id.recycolabora);
        final AdaptadorColaboradores adaptadorColaboradores = new AdaptadorColaboradores(getContext());
        recyclerColab.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerColab.setAdapter(adaptadorColaboradores);
        colaboradoresPViewModel = new ViewModelProvider(this,new ColaboradorPViewModelFactory(getActivity().getApplication(),mParam1)).get(ColaboradoresPViewModel.class);
        colaboradoresPViewModel.getPestanaColaboradoresList().observe(getViewLifecycleOwner(), new Observer<List<PestanaColaboradores>>() {
            @Override
            public void onChanged(List<PestanaColaboradores> pestanaColaboradores) {
                adaptadorColaboradores.setColaboradoresL(pestanaColaboradores);
            }
        });
        return vista;
    }
}