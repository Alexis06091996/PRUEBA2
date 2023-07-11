package com.example.sumadedosnumeros;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et1;
    EditText et2;
    TextView tv1;
    Button btnSumar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.txtNumero1);
        et2 = (EditText)findViewById(R.id.txtNumero2);
        tv1 = (TextView)findViewById(R.id.lblResultado);
        btnSumar = (Button)findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    Toast.makeText(getApplicationContext(), "a presionado el boton", Toast.LENGTH_SHORT).show(){
    }
}