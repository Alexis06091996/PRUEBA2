package com.example.sumadedosnueros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.examen11.R


class SUMA : AppCompatActivity() {
    private lateinit var txt_Resul: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma)

        txt_Resul = findViewById(R.id.resul)

        val result = intent.getIntExtra("Result", 0)
        txt_Resul.text = "El resultado es: $result"
    }
}
