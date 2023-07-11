package com.example.examen11

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton1 = findViewById<Button>(R.id.boton1)
        boton1.setOnClickListener {
            val intent: Intent = Intent(this, MENU::class.java)
            startActivity(intent)
        }

        val boton2 =findViewById<Button>(R.id.boton2)
        boton2.setOnClickListener{
            finish()

        }
    }
}