package com.example.examenb1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    val arreglo=BDDMemoria.arregloAutor
    var idItemSeleccionado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Boton
        val botonCrear=findViewById<Button>(
            R.id.btn_crear_autor
        )
        botonCrear.setOnClickListener{ irActividad(FormularioAutor::class.java)}

        //List view
        // adaptador
        val listView = findViewById<ListView>(R.id.lv_autores)
        val adaptador = ArrayAdapter(
            this, // Contexto
            android.R.layout.simple_list_item_1, // layout.xml que se va usar
            arreglo
        )
        listView.adapter = adaptador
        adaptador.notifyDataSetChanged()

        registerForContextMenu(listView)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.mi_editar ->{
                "Hacer algo con: ${idItemSeleccionado}"
                return true
            }
            R.id.mi_eliminar ->{
                abrirDialogo()
                "Hacer algo con: ${idItemSeleccionado}"
                return true
            }

            R.id.mi_ver_libros ->{
                irActividad(LibrosActivity::class.java)
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    fun abrirDialogo(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Desea eliminar?")
        builder.setPositiveButton(
            "Aceptar",
            DialogInterface.OnClickListener{ // Callback
                    dialog, which -> // ALGUNA COSA
            }
        )
        builder.setNegativeButton("Cancelar", null)



        val dialogo = builder.create()
        dialogo.show()

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // llenar las opciones del menu
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        // obtener el id del ArrayList seleccionado
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado = id
    }



    fun irActividad(
        clase: Class<*>
    ){
        val intent = Intent(this, clase)
        // NO RECIBIMOS RESPUESTA
        startActivity(intent)
        // this.startActivity()
    }
/*
    fun abrirActividadConParametros(
        clase: Class<*>
    ){
        val intentExplicito = Intent(this, clase)
        // Enviar parametros
        // (aceptamos primitivas)
        intentExplicito.putExtra("nombre", "Adrian")
        intentExplicito.putExtra("apellido", "Eguez")
        intentExplicito.putExtra("edad", 30)
        // enviamos el intent con RESPUESTA
        // RECIBIMOS RESPUESTA
        callbackContenidoIntentExplicito
            .launch(intentExplicito)
    }*/
}