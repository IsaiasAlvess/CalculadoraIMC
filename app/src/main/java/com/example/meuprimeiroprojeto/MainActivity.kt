package com.example.meuprimeiroprojeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val edtPeso: EditText = findViewById(R.id.edttext_peso)
        val edtAltura:EditText = findViewById(R.id.edittext_altura)
        val BtnCalcular: Button = findViewById(R.id.btnCalcular)


        BtnCalcular.setOnClickListener {

            val pesoSTR = edtPeso.text.toString()
            val alturaSTR = edtAltura.text.toString()

            if (alturaSTR.isNotEmpty() && pesoSTR.isNotEmpty()) {

                val peso: Float = edtPeso.text.toString().toFloat()
                val Altura: Float = edtAltura.text.toString().toFloat()

                val AlturaFinal: Float = Altura * Altura
                val result = peso / AlturaFinal


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }

                startActivity(intent)
            }else{
                Toast.makeText(this , "preencher todos os campos", Toast.LENGTH_SHORT).show()
            }


        }

        }
    }
