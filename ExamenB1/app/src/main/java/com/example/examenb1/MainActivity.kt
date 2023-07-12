package com.example.examenb1

import android.app.Activity
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
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var adaptador: ArrayAdapter<Autor>
    var idItemSeleccionado = 0

    val autorDAO= AutorDAO()
    val callback=  registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
    ){
        result ->
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val listView = findViewById<ListView>(R.id.lv_autores)
        adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            autorDAO.getLista()
        )
        listView.adapter = adaptador
        adaptador.notifyDataSetChanged()

        val botonCrear = findViewById<Button>(R.id.btn_crear_autor)
        botonCrear.setOnClickListener {

            irActividad(FormularioAutor::class.java)
        }

        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado = id
    }

    fun abrirDialogoEliminar() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Esta seguro que desea eliminar el autor?")
        builder.setPositiveButton("Si") { dialog, which ->
            if(autorDAO.delete(autorDAO.getLista().get(idItemSeleccionado).getId())){
                adaptador.notifyDataSetChanged()
            }
        }
        builder.setNegativeButton("No", null)

        val dialog = builder.create()
        dialog.show()
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.mi_editar -> {
                abrirActividadConParametros(FormularioAutor::class.java)
                true
            }

            R.id.mi_eliminar -> {
                abrirDialogoEliminar()
                true
            }

            R.id.mi_ver_libros -> {
                abrirActividadConParametros(LibrosActivity::class.java)
                true
            }

            else -> {
                super.onContextItemSelected(item)
            }
        }

    }

    override fun onRestart() {
        super.onRestart()
        adaptador.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        adaptador.notifyDataSetChanged()
    }

    fun irActividad(
        clase: Class<*>
    ){
        val intent = Intent(this, clase)
        startActivity(intent)
    }

    fun abrirActividadConParametros(
        clase: Class<*>
    ){
        val intentExplicito = Intent(this, clase)
        // Enviar parametros
        // (aceptamos primitivas)
        intentExplicito.putExtra("id", autorDAO.getLista().get(idItemSeleccionado).getId())
        // enviamos el intent con RESPUESTA
        // RECIBIMOS RESPUESTA
        callback.launch(intentExplicito)
    }
}


