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
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class LibrosActivity : AppCompatActivity() {
    lateinit var adaptador: ArrayAdapter<Libro>
    var idItemSeleccionado = 0

    val libroDAO = LibroDAO()
    var id: Int? = -1
    val callback = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)
        id = intent.getIntExtra("id", -1)


        if (id != -1) {
            val listView = findViewById<ListView>(R.id.lv_libros)
            adaptador = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                libroDAO.getLista(id!!)
            )
            listView.adapter = adaptador

            val botonCrear = findViewById<Button>(R.id.btn_crear_libro)
            botonCrear.setOnClickListener {
                irActividad(FormularioLibro::class.java)
            }

            registerForContextMenu(listView)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_libro, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado = id
    }

    fun abrirDialogoEliminar() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("¿Está seguro de que desea eliminar el libro?")
        builder.setPositiveButton("Sí") { dialog, which ->
            val libroEliminado = libroDAO.getLista().get(idItemSeleccionado)
            if (libroDAO.delete(libroEliminado.getId())) {
                adaptador.remove(libroEliminado)
                adaptador.notifyDataSetChanged()
            }
        }
        builder.setNegativeButton("No", null)

        val dialog = builder.create()
        dialog.show()
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mi_editar -> {
                abrirActividadConParametros(FormularioLibro::class.java)
                true
            }
            R.id.mi_eliminar -> {
                abrirDialogoEliminar()
                true
            }
            else -> {
                super.onContextItemSelected(item)
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        adaptador.clear()
        adaptador.addAll(libroDAO.getLista(id!!))
        adaptador.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        adaptador.clear()
        adaptador.addAll(libroDAO.getLista(id!!))
        adaptador.notifyDataSetChanged()
    }

    fun irActividad(clase: Class<*>) {
        val intent = Intent(this, clase)
        startActivity(intent)
    }

    fun abrirActividadConParametros(clase: Class<*>) {
        val intentExplicito = Intent(this, clase)
        intentExplicito.putExtra("id", libroDAO.getLista(id!!).get(idItemSeleccionado).getId())
        intentExplicito.putExtra("idAutor", id)
        callback.launch(intentExplicito)
    }

    fun abrirDialogo(cadena: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(cadena)
        builder.setPositiveButton("Aceptar") { dialog, which -> dialog.dismiss() }

        val dialogo = builder.create()
        dialogo.setCancelable(false)
        dialogo.show()
    }
}

