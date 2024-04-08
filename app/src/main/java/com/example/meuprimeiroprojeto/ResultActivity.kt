package com.example.meuprimeiroprojeto

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val TvResult = findViewById<TextView>(R.id.texteview_result)
        val tvclassificacao = findViewById<TextView>(R.id.texteview_classificacao)
        val Result = intent.getFloatExtra("EXTRA_RESULT", 0.1F)

        TvResult.text = Result.toString()

        //*
        /* MENOR QUE 18,5	    MAGREZA	0
       ENTRE 18,5 E 24,9	NORMAL	0
       ENTRE 25,0 E 29,9	SOBREPESO	I
       ENTRE 30,0 E 39,9	OBESIDADE	II
       MAIOR QUE 40,0	    OBESIDADE GRAVE	III
       */


       val classificacao = if(Result < 18.5f ){
            "ABAIXO DO PESO"
        }else if(Result in 18.5f..24.9f){
            "NORMAL"
        }else if(Result in 25.0f..29.9f){
            "SOBREPESO"
        }else if(Result in 30.0f..39.9f){
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }
tvclassificacao.text = getString(R.string.mensage_classificacao, classificacao)

        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }


        }

