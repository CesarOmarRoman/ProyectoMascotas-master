package com.example.maccesarr.proyectomascotas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.maccesarr.proyectomascotas.Adaptadores.AdaptadorMascotas;
import com.example.maccesarr.proyectomascotas.Adaptadores.PageAdapter;
import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.fragments.PerfilFragment;
import com.example.maccesarr.proyectomascotas.fragments.PrincipalFragment;

import static android.support.v7.appcompat.R.styleable.Toolbar;
import static android.support.v7.recyclerview.R.styleable.RecyclerView;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    SharedPreferences.Editor editor;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Agregar para dar soporte al botón de opciones
        toolbar =(Toolbar)findViewById(R.id.Toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        setUpViewPager();

        setSupportActionBar(toolbar);

        preferencias=getSharedPreferences("SICAM", Context.MODE_PRIVATE);
        editor =preferencias.edit();
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new PrincipalFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.dog_house_80);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_96);
    }


    //Métodos para crear el menú de opciones junto con el XML de Menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent= new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;
            case R.id.mAcercaDe:
                Intent intent2= new Intent(this, BioActivity.class);
                startActivity(intent2);
                break;
            case R.id.mReiniciar:
                Reiniciar();
                break;
        }
        return true;
    }
    //Menu





    public void Favorito(View view){
        Intent intent = new Intent(this, Top5Mascotas.class);
        startActivity(intent);
    }

    public void Agregar_Imagen(View view){
        Toast.makeText(this,"En construcción agregar imagenes", Toast.LENGTH_LONG).show();
    }

    public void Reiniciar(){
        Toast.makeText(this,"Se reiniciar los parametros", Toast.LENGTH_LONG).show();
        editor.clear();
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }





}
