package com.example.inge;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.inge.pestanas.PestañasAdaptador;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Trabajo_seleccionado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Trabajo_seleccionado extends Fragment {
    ViewPager2 viewPager;
    TabLayout tabLayout;
    MaterialToolbar barra;
    PopupMenu popupMenu;
    SharedPreferences sharedPreferences;
    FloatingActionButton floatingActionButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int idproy;

    public Trabajo_seleccionado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Trabajo_seleccionado.
     */
    // TODO: Rename and change types and number of parameters
    public static Trabajo_seleccionado newInstance(String param1, String param2) {
        Trabajo_seleccionado fragment = new Trabajo_seleccionado();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idproy = Trabajo_seleccionadoArgs.fromBundle(getArguments()).getIdproy();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_trabajo_seleccionado, container, false);
        floatingActionButton = view.findViewById(R.id.floatingActionButton4);
        barra = (MaterialToolbar) view.findViewById(R.id.barr);
        viewPager = (ViewPager2) view.findViewById(R.id.paginacion);
        viewPager.setAdapter(new PestañasAdaptador(this,idproy));
        tabLayout =(TabLayout) view.findViewById(R.id.pestana);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: {
                        tab.setText("Proyecto-Actividades");
                        break;
                    }
                    case 1: {
                        tab.setText("Colaboradores");
                        break;
                    }
                }
            }
        });
        tabLayoutMediator.attach();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Trabajo terminado",Toast.LENGTH_SHORT).show();
            }
        });
        barra.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.barragre:
                        Bundle bundle = new Bundle();
                        bundle.putInt("idpa",idproy);
                        Navigation.findNavController(barra).navigate(R.id.ingresartrabajo,bundle);

                        return true;
                    case R.id.baredit:
                        popupMenu = new PopupMenu(getContext(),getParentFragment().getView().findViewById(R.id.baredit));
                        popupMenu.inflate(R.menu.editoption);
                        configurarPopmenu();
                        popupMenu.show();
                        return true;
                    default:
                        Toast.makeText(getContext(),"default",Toast.LENGTH_SHORT).show();
                        return false;
                }
            }
        });

        return view;
    }
    public void configurarPopmenu(){
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.editact:
                        Toast.makeText(getContext(),"editar actividad",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.editproy:
                        Bundle bundle = new Bundle();
                        bundle.putInt("id",idproy);
                        Navigation.findNavController(barra).navigate(R.id.agregarPoyecto,bundle);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}