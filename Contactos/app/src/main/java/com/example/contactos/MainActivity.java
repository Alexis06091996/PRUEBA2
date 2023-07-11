package com.example.contactos;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.contactos.adaptadores.ListaContactosAdapter;
import com.example.contactos.db.DbContactos;
import com.example.contactos.db.DbHelper;
import com.example.contactos.entidades.Contactos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCrear;
    RecyclerView listacontactos;
    ArrayList<Contactos> listaArrayContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear= findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent (v.getContext(),Menu_Crud.class);
                    startActivityForResult(intent, 0);




                } else {
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR BD", Toast.LENGTH_LONG).show();

                }

            }

        });
    }






}