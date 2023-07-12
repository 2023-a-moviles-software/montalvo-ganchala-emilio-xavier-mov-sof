package com.example.examenb1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FormularioAutor : AppCompatActivity() {
    val autorDAO=AutorDAO()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_autor)
        val id: Int? = intent.getIntExtra("id",-1)

        val botonAceptar=findViewById<Button>(R.id.btn_aceptar_autor)
        val botonCancelar=findViewById<Button>(R.id.btn_cancelar_autor)
        val campoNombre=findViewById<EditText>(R.id.et_nombre)
        val campoApellido=findViewById<EditText>(R.id.et_apellido)
        val fechaNacimiento=findViewById<EditText>(R.id.et_fecha_nacimiento)
        val campoGenero=findViewById<EditText>(R.id.et_genero)
        val campoNacionalidad=findViewById<EditText>(R.id.et_nacionalidad)
        val textoTop=findViewById<TextView>(R.id.tv_top_autor)

        botonCancelar.setOnClickListener {
            irActividad(MainActivity::class.java)
        }

        if (id!=-1){
            val autor=autorDAO.get(id!!)
            textoTop.text = "Editar Autor"


            campoNombre.setText(autor!!.getNombre())
            campoApellido.setText(autor.getApellido())
            fechaNacimiento.setText((autor.getFechaNacimiento()!!.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))))
            campoGenero.setText(autor.getGenero()+"")
            campoNacionalidad.setText(autor.getNacionalidad())

            botonAceptar.setOnClickListener {


                try {


                    val nombre = campoNombre.text.toString()
                    val apellido = campoApellido.text.toString()
                    val nacimiento = fechaNacimiento.text.toString()
                    val genero = campoGenero.text.toString()
                    val nacionalidad = campoNacionalidad.text.toString()

                    if(nombre !=""
                        && apellido !=""
                        && nacimiento !=""
                        && genero !=""
                        && nacionalidad !=""
                    ){
                        autor.setNombre(nombre)
                        autor.setApellido(apellido)
                        autor.setFechaNacimiento(LocalDate.parse(nacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                        autor.setGenero(genero.first())
                        autor.setNacionalidad(nacionalidad)
                        autorDAO.edit(autor)
                        abrirDialogoYVolver("Autor actualizado correctamente")
                    }else{
                        abrirDialogo("Faltan datos por ingresar")
                    }


                }catch (e:Exception){
                    abrirDialogo("Los datos no estan en el formato correcto")
                }

            }
        }else{


            botonAceptar.setOnClickListener {

                try {
                    textoTop.text = "Crear Autor"
                    val nombre = campoNombre.text.toString()
                    val apellido = campoApellido.text.toString()
                    val nacimiento = fechaNacimiento.text.toString()
                    val genero = campoGenero.text.toString()
                    val nacionalidad = campoNacionalidad.text.toString()

                    if(nombre !=""
                        && apellido !=""
                        && nacimiento !=""
                        && genero !=""
                        && nacionalidad !=""
                    ){
                        val autor=Autor(0,
                            nombre,
                            apellido,
                            LocalDate.parse(nacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            genero.first(),
                            nacionalidad)

                        autorDAO.add(autor)
                        abrirDialogo("Autor registrado exitosamente")
                        campoNombre.setText("")
                        campoApellido.setText("")
                        fechaNacimiento.setText("")
                        campoGenero.setText("")
                        campoNacionalidad.setText("")

                    }else{
                        abrirDialogo("Faltan datos por ingresar")
                    }

                }catch (e:Exception){
                    abrirDialogo("Los datos no estan en el formato correcto")
                }

            }


        }
    }

    fun abrirDialogoYVolver(cadena:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(cadena)
        builder.setPositiveButton(
            "Aceptar",
            DialogInterface.OnClickListener{ // Callback
                    dialog, which -> irActividad(MainActivity::class.java)
            }
        )

        val dialogo = builder.create()
        dialogo.setCancelable(false)
        dialogo.show()

    }


    fun abrirDialogo(cadena:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(cadena)
        builder.setPositiveButton(
            "Aceptar",
            DialogInterface.OnClickListener{ // Callback
                    dialog, which -> dialog.cancel()
            }
        )

        val dialogo = builder.create()
        dialogo.setCancelable(false)
        dialogo.show()

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