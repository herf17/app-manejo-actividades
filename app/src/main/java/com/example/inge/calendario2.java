package com.example.inge;



import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inge.viewmodel.AgregarActividadViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calendario2 #newInstance} factory method to
 * create an instance of this fragment.
 */
public class calendario2 extends Fragment implements AdapterView.OnItemSelectedListener {
    Button b1;
    CalendarView calendarView;
    EditText e1,e3,hora;
    String fecha, horas;
    int id;
    AgregarActividadViewModel agregarActividadViewModel;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public calendario2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ColaboradoresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static calendario2 newInstance(String param1, String param2) {
        calendario2 fragment = new calendario2();
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
            id = getArguments().getInt("idpa");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista3 =inflater.inflate(R.layout.calendar2, container, false);
        calendarView = vista3.findViewById(R.id.calen);
        b1 =(Button) vista3.findViewById(R.id.btnguardar);
        e1 = vista3.findViewById(R.id.etlugaract);
        e3=(EditText)vista3.findViewById(R.id.texto);
        hora = vista3.findViewById(R.id.hora1);
        hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment fragment = new SelectorHoraFragment();
                fragment.show(getParentFragmentManager(), "horaSelector");
            }
        });
        agregarActividadViewModel = new ViewModelProvider(requireActivity()).get(AgregarActividadViewModel.class);
        agregarActividadViewModel.getHora().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                hora.setText(s);
            }
        });
        final TextView thedate = (TextView) vista3.findViewById(R.id.textView);
        Toast.makeText(getContext(),"id: "+id,Toast.LENGTH_SHORT).show();
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int año, int mes, int dia) {
                int m = mes +1;
                fecha = dia + "/" + m + "/"+  año;
                thedate.setText(fecha);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarActividadViewModel.insertarNewActi(e3.getText().toString(),thedate.getText().toString(),e1.getText().toString(),id);
                final NavController navController = Navigation.findNavController(view);
                navController.popBackStack();
            }
        });
        Spinner spinner = (Spinner) vista3.findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener(this);
        String [] trabajoadto = getResources().getStringArray(R.array.trabajadores);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,trabajoadto);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        return vista3;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        agregarActividadViewModel.setIdtr(adapterView.getItemAtPosition(i).toString());
        Toast.makeText(getContext()," "+agregarActividadViewModel.getIdtr(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}