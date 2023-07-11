package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contactos.db.DbContactos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre,txtTelefono,txtCorreo;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        txtNombre=findViewById(R.id.txtNombre);
        txtTelefono=findViewById(R.id.txtTelefono);
        txtCorreo=findViewById(R.id.txtCorreo);
        btnGuarda=findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
               long id =  dbContactos.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(),txtCorreo.getText().toString());
            if(id>0){
                Toast.makeText(NuevoActivity.this,"REGISTRO GUARDADO",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(v.getContext(), Menu_Crud.class);
                startActivityForResult(intent, 0);
                limpiar();

            }else {
                Toast.makeText(NuevoActivity.this,"ERROR AL GUARDAR REGISTRO",Toast.LENGTH_LONG).show();
            }
            }
        });
    }
        private void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");

    }
}