package com.example.inge;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IngColaborador #newInstance} factory method to
 * create an instance of this fragment.
 */
public class IngColaborador extends Fragment {
    Button bt2;

    EditText et1, et2;

    Spinner et3;

    String Estado;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IngColaborador() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IngColaborador.
     */
    // TODO: Rename and change types and number of parameters
    public static IngColaborador newInstance(String param1, String param2) {
        IngColaborador fragment = new IngColaborador();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vista2 =inflater.inflate(R.layout.ingresarcolaborador, container, false);
        et1 =(EditText)vista2.findViewById(R.id.etnombre);
        et2 =(EditText)vista2.findViewById(R.id.etcargo);
        bt2 =(Button) vista2.findViewById(R.id.button);
        et3=(Spinner)vista2.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(),R.array.estado,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        et3.setAdapter(adapter);
        super.onCreate(savedInstanceState);
        et3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Estado= parent.getItemAtPosition(pos).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        bt2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String nombre = et1.getText().toString();
                String cargo = et2.getText().toString();

                Toast.makeText(getContext(), "Datos grabados", Toast.LENGTH_LONG).show();

                IngColaboradorDirections.ActionIngColablToColaboradosl accionNom = IngColaboradorDirections.actionIngColablToColaboradosl(nombre);
                Navigation.findNavController(v).navigate(accionNom);

                IngColaboradorDirections.ActionIngColablToColaboradosl accionCargo = IngColaboradorDirections.actionIngColablToColaboradosl(cargo);
                Navigation.findNavController(v).navigate(accionCargo);

                IngColaboradorDirections.ActionIngColablToColaboradosl accionEstado = IngColaboradorDirections.actionIngColablToColaboradosl(Estado);
                Navigation.findNavController(v).navigate(accionEstado);

            }
        });

        return vista2;
    }
}