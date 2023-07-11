package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactos.adaptadores.ListaContactosAdapter;
import com.example.contactos.db.DbContactos;
import com.example.contactos.db.DbHelper;
import com.example.contactos.entidades.Contactos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.ListIterator;

public class BuscarActivity extends AppCompatActivity {


    EditText txtNombre, txtTelefono, txtCorreo;
    Button btnGuard, btnNuevos;
    FloatingActionButton fabEditar, fabEliminar;

    Contactos contacto;
    int id = 0;

    RecyclerView listacontactos;
    ArrayList<Contactos> listaArrayContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        listacontactos = findViewById(R.id.listaContactos);
        listacontactos.setLayoutManager(new LinearLayoutManager(this));

        DbContactos dbContactos = new DbContactos(BuscarActivity.this);
        listaArrayContactos = new ArrayList<>();

        ListaContactosAdapter adapter = new ListaContactosAdapter(dbContactos.mostrarContactos());
        listacontactos.setAdapter(adapter);
    }
}



