package com.example.prueba_ii_parcial_chuquin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_curso,btn_quienes,btn_contactos;
    Button btnsalir;
    String  _url="https://www.espe.edu.ec/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_quienes= (ImageButton) findViewById(R.id.btn_quienes);
        btn_curso= (ImageButton) findViewById(R.id.btn_cursos);
        btn_contactos= (ImageButton) findViewById(R.id.btn_contacto);
        btnsalir=(Button) findViewById(R.id.btn_salir);
        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
finish();
            }
        });




        btn_quienes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Uri _link= Uri.parse(_url);
                Intent intent = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(intent);
            }
        });

btn_curso.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, cursos.class);
        startActivity(intent);
    }
});
        btn_contactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, contacto.class);
                startActivity(intent);

            }
        });

    }
}