package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Crud extends AppCompatActivity {
    Button btnNuevo,btnEliminar,btnModificar,btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_crud);

        btnNuevo= findViewById(R.id.btnNuevo);
        btnBuscar= findViewById(R.id.btnBuscar);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                         Intent intent = new Intent(v.getContext(), NuevoActivity.class);
                    startActivityForResult(intent, 0);

                }
                    });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VerActivity.class);
                startActivityForResult(intent, 0);

            }
        });





}
}