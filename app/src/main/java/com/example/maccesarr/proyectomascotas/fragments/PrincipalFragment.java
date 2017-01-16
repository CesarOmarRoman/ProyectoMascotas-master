package com.example.maccesarr.proyectomascotas.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maccesarr.proyectomascotas.Adaptadores.AdaptadorMascotas;
import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.R;

import java.util.ArrayList;

import static com.example.maccesarr.proyectomascotas.R.id.tabLayout;
import static com.example.maccesarr.proyectomascotas.R.id.viewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaDeUsuarios;
    SharedPreferences.Editor editor;
    SharedPreferences preferencias;

    public PrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_principal, container, false);

        listaDeUsuarios= (RecyclerView) v.findViewById(R.id.rvMascotas);

        preferencias=getActivity().getSharedPreferences("SICAM", Context.MODE_PRIVATE);
        editor =preferencias.edit();

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //GridLayoutManager llm = new GridLayoutManager(this, 2);
        //StaggeredGridLayoutManager llm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeUsuarios.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        AdaptadorMascotas adaptadorMascotas = new AdaptadorMascotas(mascotas, getActivity());
        listaDeUsuarios.setAdapter(adaptadorMascotas);
    }

    public void inicializarListaContactos(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(1, "Bronco", R.drawable.dog1, Integer.parseInt(preferencias.getString("Bronco","0"))));
        mascotas.add(new Mascota(2, "Algodón", R.drawable.dog2, Integer.parseInt(preferencias.getString("Barto","0"))));
        mascotas.add(new Mascota(3, "Duffman", R.drawable.dog3, Integer.parseInt(preferencias.getString("Spiderman","0"))));
        mascotas.add(new Mascota(4, "Intenso", R.drawable.dog4, Integer.parseInt(preferencias.getString("Intenso","0"))));
        mascotas.add(new Mascota(5, "Max", R.drawable.dog5, Integer.parseInt(preferencias.getString("Max","0"))));
        mascotas.add(new Mascota(6, "Macho", R.drawable.dog6, Integer.parseInt(preferencias.getString("Macho","0"))));

    }

}
