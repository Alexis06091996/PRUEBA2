package com.example.examen11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.sumadedosnueros.SUMA

class MENU : AppCompatActivity() {

    lateinit var numero_1: EditText
    lateinit var numero_2: EditText
    lateinit var sumar_1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        numero_1 = findViewById(R.id.numero1)
        numero_2 = findViewById(R.id.numero2)
        sumar_1 = findViewById(R.id.calcular)

        sumar_1.setOnClickListener(View.OnClickListener {
            val num1 = Integer.parseInt(numero_1.text.toString())
            val num2 = Integer.parseInt(numero_2.text.toString())
            val sum = num1 + num2



            val intent = Intent(this, SUMA::class.java)
            intent.putExtra("Result", sum)
            startActivity(intent)
        })
    }
}