package com.example.myapplication

import android.content.DialogInterface
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

class BListView : AppCompatActivity() {
    val arreglo = BBaseDatosMemoria.arregloBEntrenador
    var idItemSeleccionado = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blist_view)

        //adaptador
        val listView= findViewById<ListView>(R.id.lv_list_view)
        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arreglo)
        listView.adapter=adaptador
        adaptador.notifyDataSetChanged()

        val botonAnadirListView = findViewById<Button>(R.id.btn_ir_list_view)
        botonAnadirListView.setOnClickListener{
            anadirEntrenador(adaptador)
        }
        registerForContextMenu(listView)
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.mi_editar ->{

                return true
            }
            R.id.mi_eliminar->{
                return true
            }
            else ->super.onContextItemSelected(item)     }



    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        //llenar las opciones del menu

        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)

        //obtener el id del ArrayList seleccionedo
        val info =menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado=id
    }




    fun anadirEntrenador(adaptador: ArrayAdapter<BEntrenador>){
        arreglo.add(
            BEntrenador(4,"Adrian","Descripccion")

        )
        adaptador.notifyDataSetChanged()
    }

    fun abrirDialogo(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Desea eliminar")
        builder.setPositiveButton("Aceptar",DialogInterface.OnClickListener{
            dialog,which ->
        }

        )

        builder.setNegativeButton("Cancelar",null)
        val opciones = resources.getStringArray(R.array.string_array_opciones_dialogo)

        val seleccionPrevia = booleanArrayOf(true,false,false)

        builder.setMultiChoiceItems(
            opciones,
            seleccionPrevia,
            {
                dialog,which,isChecked ->
                "Dio clic en el item ${which}"
            }
        )

        val dialogo = builder.create()

    }




}