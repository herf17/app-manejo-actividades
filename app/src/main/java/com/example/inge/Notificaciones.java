package com.example.inge;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Notificaciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Notificaciones extends Fragment {
String[] listan;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Notificaciones() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Notificaciones.
     */
    // TODO: Rename and change types and number of parameters
    public static Notificaciones newInstance(String param1, String param2) {
        Notificaciones fragment = new Notificaciones();
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
        final View vista =inflater.inflate(R.layout.fragment_notificaciones, container, false);
// Instancia del ListView.

        final ListView listView = (ListView) vista.findViewById(R.id.user_list);
        ArrayList<HashMap<String, String>> list_of_bookmarks = new ArrayList<HashMap<String, String>>();

        String[] from = { "notificacion_key"};
        String[] name_of_bookmarks = { "notificacion" };

        for(int i=0;i<1;i++)
        {
            HashMap<String, String> b = new HashMap<String, String>();
            b.put(from[i],name_of_bookmarks[i]);
            list_of_bookmarks.add(b);
        }

    int[] to = { R.id.notificacion};

    SimpleAdapter adapter = new SimpleAdapter(getContext(), list_of_bookmarks, R.layout.listrow, from, to);
        listView.setAdapter(adapter);

        return vista;
    }
}