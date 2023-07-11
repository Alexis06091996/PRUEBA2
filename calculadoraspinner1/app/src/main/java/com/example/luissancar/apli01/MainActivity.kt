package com.example.luissancar.apli01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerAdapter= ArrayAdapter.createFromResource(this,R.array.operacion,android.R.layout.simple_spinner_item)
        spinner.adapter=spinnerAdapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {

            }


            override fun onNothingSelected(parent: AdapterView<out Adapter>?) {
            }

        }


        button.setOnClickListener {
            sumar()
        }
        button.setEnabled(false)
        datoa.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                activarBoton()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })


        editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                activarBoton()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

    }


    fun sumar() {


        val selected = spinner.selectedItemPosition
        val o1=datoa.text.toString().toInt()
        val o2=editText2.text.toString().toInt()
        var res:Int=0
        println(selected)
        when (selected) {
            0->res=o1+o2
            1->res=o1-o2
            2->res=o1*o2
            3->if (o2==0) {
                res = -1
                val context = applicationContext
                Toast.makeText(context,R.string.division, Toast.LENGTH_LONG).show()
            }
            else
                res=o1/o2

        }

        resultado.text=res.toString()


    }
    fun activarBoton() {
        if (datoa.getText().length>0 && editText2.getText().length>0)
            button.setEnabled(true)
        else
            button.setEnabled(false)




    }
}
