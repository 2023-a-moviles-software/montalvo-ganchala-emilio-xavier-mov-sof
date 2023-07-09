package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ECrudentrenador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecrudentrenador)
        val botonBuscarBDD=findViewById<Button>(R.id.btn_buscar_bdd)
        botonBuscarBDD.setOnClickListener {
            val id = findViewById<EditText>(R.id.btn_buscar_bdd)
            val nombre=findViewById<EditText>(R.id.input_nombre)
            val descripcion=findViewById<EditText>(R.id.input_descripcion)
            val entrenador=EBaseDeDatos.tablaentrenador!!.consultarentrenadorPorID(
                id.text.toString().toInt()
            )
            id.setText(entrenador.id.toString())
            nombre.setText(entrenador.nombre)
            descripcion.setText(entrenador.descripcion)
        }

        val botonCrearBDD=findViewById<Button>(R.id.btn_crear_bdd)
        botonCrearBDD.setOnClickListener {
            val nombre=findViewById<EditText>(R.id.input_nombre)
            val descripcion=findViewById<EditText>(R.id.input_descripcion)
            EBaseDeDatos.tablaentrenador!!.crearEntrenador(
                nombre.text.toString(),
                descripcion.text.toString()
            )
        }

        val botonActualizarBDD=findViewById<Button>(R.id.btn_actualizar_bdd)
        botonActualizarBDD.setOnClickListener {
            val id = findViewById<EditText>(R.id.btn_buscar_bdd)
            val nombre=findViewById<EditText>(R.id.input_nombre)
            val descripcion=findViewById<EditText>(R.id.input_descripcion)
            EBaseDeDatos.tablaentrenador!!.actualizarEntrenadorFormulario(
                nombre.text.toString(),
                descripcion.text.toString(),
                id.text.toString().toInt()
            )
        }

        val botonEliminarBDD = findViewById<Button>(R.id.btn_eliminar_bdd)
        botonEliminarBDD.setOnClickListener {
            val id = findViewById<EditText>(R.id.input_id)
            EBaseDeDatos.tablaentrenador!!.eliminarEntrenadorformulario(
                id.text.toString().toInt()
            )
        }

    }
}