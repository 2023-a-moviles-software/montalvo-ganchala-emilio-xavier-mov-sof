package com.example.threads

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val arreglo=BDDMemoria.arregloPublicaciones
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //definir lista
        val recyclerView = findViewById<RecyclerView>(R.id.rv_publicaciones)

        val adaptador=FRecyclerViewAdaptadorPublicacion(
            this,
            arreglo,
            recyclerView
        )

        /*val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        itemDecoration.setDrawable(ColorDrawable(Color.TRANSPARENT)) // Esto establecerá el color de fondo transparente
        recyclerView.addItemDecoration(itemDecoration)*/

        recyclerView.adapter=adaptador
        recyclerView.itemAnimator=androidx.recyclerview.widget
            .DefaultItemAnimator()
        recyclerView.layoutManager=androidx.recyclerview.widget
            .LinearLayoutManager(this)
        adaptador.notifyDataSetChanged()



    }
}