package com.example.maccesarr.proyectomascotas;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

public class ContactoActivity extends AppCompatActivity {

    EditText nombre, correo, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar_DETALLE);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText)findViewById(R.id.editTextNombre_Contacto);
        correo = (EditText)findViewById(R.id.editTextEmail_Contacto);
        mensaje = (EditText)findViewById(R.id.editTextMensaje_Contacto);

    }

    public void EnviarInformación (View view){

    }

    public void displayMessage(String message) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

}

