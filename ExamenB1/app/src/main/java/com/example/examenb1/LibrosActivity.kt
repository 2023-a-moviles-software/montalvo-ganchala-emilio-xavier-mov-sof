package com.example.examenb1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LibrosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)
        //Boton
        val botonCrear=findViewById<Button>(
            R.id.btn_crear_libro
        )
        botonCrear.setOnClickListener{ irActividad(FormularioLibro::class.java)}
    }

    fun irActividad(
        clase: Class<*>
    ){
        val intent = Intent(this, clase)
        // NO RECIBIMOS RESPUESTA
        startActivity(intent)
        // this.startActivity()
    }
}