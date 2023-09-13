package com.example.examenb1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FormularioLibro : AppCompatActivity() {
    val libroDAO:LibroDAO= BDD.libroDAO!!
    val autorDAO:AutorDAO= BDD.autorDAO!!
    var id: Int? =null
    var idAutor: Int? =null
    val callback = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_libro)
        id=intent.getIntExtra("id", -1)
        idAutor=intent.getIntExtra("idAutor", -1)


        val botonAceptar = findViewById<Button>(R.id.btn_aceptar_libro)
        val botonCancelar = findViewById<Button>(R.id.btn_cancelar_libro)
        val campoTitulo = findViewById<EditText>(R.id.et_titulo)
        val campoEditorial = findViewById<EditText>(R.id.et_editorial)
        val fechaPublicacion = findViewById<EditText>(R.id.et_fecha_publicacion)
        val campoDisponibilidad = findViewById<CheckBox>(R.id.cb_disponiblidad)
        val campoPrecio = findViewById<EditText>(R.id.et_precio)
        val campoAutor = findViewById<EditText>(R.id.at_autor)

        val textoTop = findViewById<TextView>(R.id.tv_titulo_libro)

        botonCancelar.setOnClickListener {
            onBackPressed()
        }

        if (id != -1) {
            val libro = libroDAO.get(id!!)
            if (libro != null) {
                textoTop.text = "Editar Libro"

                campoTitulo.setText(libro.getTitulo())
                campoEditorial.setText(libro.getEditorial())
                fechaPublicacion.setText(
                    (libro.getFechaPublicacion()?.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))))
                campoDisponibilidad.isChecked = libro.getDisponible()
                campoPrecio.setText(libro.getPrecio().toString())
                campoAutor.setText(libro.getIdAutor().toString())

                botonAceptar.setOnClickListener {
                    try {
                        val titulo = campoTitulo.text.toString()
                        val editorial = campoEditorial.text.toString()
                        val publicacion = fechaPublicacion.text.toString()
                        val disponibilidad = campoDisponibilidad.isChecked
                        val precio = campoPrecio.text.toString()
                        val idAutor = campoAutor.text.toString()

                        if (titulo.isNotBlank() &&
                            editorial.isNotBlank() &&
                            publicacion.isNotBlank() &&
                            precio.isNotBlank() &&
                            idAutor.isNotBlank() &&
                            autorDAO.existe(idAutor.toInt())
                        ) {
                            libro.setTitulo(titulo)
                            libro.setEditorial(editorial)
                            libro.setFechaPublicacion(
                                LocalDate.parse(
                                    publicacion,
                                    DateTimeFormatter.ofPattern("dd/MM/yyyy")
                                )
                            )
                            libro.setDisponible(disponibilidad)
                            libro.setPrecio(precio.toDouble())
                            libro.setIdAutor(idAutor.toInt())
                            libroDAO.edit(libro)
                            abrirDialogoYVolver("Libro actualizado correctamente")
                        } else {
                            if (!autorDAO.existe(idAutor.toInt())) {
                                abrirDialogo("El autor no existe")
                            } else {
                                abrirDialogo("Faltan datos por ingresar")
                            }
                        }
                    } catch (e: Exception) {
                        println(e.stackTrace)
                        abrirDialogo("Los datos no están en el formato correcto")
                    }
                }
            } else {
                abrirDialogo("El libro no existe")
            }
        } else {
            textoTop.text = "Crear Libro"

            botonAceptar.setOnClickListener {
                try {
                    val titulo = campoTitulo.text.toString()
                    val editorial = campoEditorial.text.toString()
                    val publicacion = fechaPublicacion.text.toString()
                    val disponibilidad = campoDisponibilidad.isChecked
                    val precio = campoPrecio.text.toString()
                    val idAutor = campoAutor.text.toString()

                    if (titulo.isNotBlank() &&
                        editorial.isNotBlank() &&
                        publicacion.isNotBlank() &&
                        precio.isNotBlank() &&
                        idAutor.isNotBlank() &&
                        autorDAO.existe(idAutor.toInt())
                    ) {
                        val libro = Libro(
                            0,
                            titulo,
                            editorial,
                            LocalDate.parse(publicacion, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            disponibilidad,
                            precio.toDouble(),
                            idAutor.toInt()
                        )

                        libroDAO.add(libro)
                        abrirDialogo("Libro registrado exitosamente")

                        campoTitulo.setText("")
                        campoEditorial.setText("")
                        fechaPublicacion.setText("")
                        campoDisponibilidad.isChecked = false
                        campoPrecio.setText("")
                        campoAutor.setText("")
                    } else {
                        if (!autorDAO.existe(idAutor.toInt())) {
                            abrirDialogo("El autor no existe")
                        } else {
                            abrirDialogo("Faltan datos por ingresar")
                        }
                    }
                } catch (e: Exception) {
                    abrirDialogo("Los datos no están en el formato correcto")
                }
            }
        }
    }

    private fun abrirDialogoYVolver(cadena: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(cadena)
        builder.setPositiveButton("Aceptar") { dialog, _ ->
            abrirActividadConParametros(LibrosActivity::class.java)
            dialog.dismiss()
        }

        val dialogo = builder.create()
        dialogo.setCancelable(false)
        dialogo.show()
    }

    private fun abrirDialogo(cadena: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(cadena)
        builder.setPositiveButton("Aceptar") { dialog, _ ->
            dialog.dismiss()
        }

        val dialogo = builder.create()
        dialogo.setCancelable(false)
        dialogo.show()
    }

    fun abrirActividadConParametros(clase: Class<*>) {
        val intentExplicito = Intent(this, clase)
        intentExplicito.putExtra("id", idAutor)
        callback.launch(intentExplicito)
    }
}

