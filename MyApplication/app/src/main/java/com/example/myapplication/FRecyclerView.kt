package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FRecyclerView : AppCompatActivity() {
    var totalLikes=0
    val arreglo=BBaseDatosMemoria.arregloBEntrenador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frecycler_view)
        //Definir lista
        val recyclerView = findViewById<RecyclerView>(
            R.id.rv_entrenadores
        )

        val adaptador=FRecyclerViewAdaptadorNombreCedula(
            this,
            arreglo,
            recyclerView
        )
        recyclerView.adapter=adaptador
        recyclerView.itemAnimator=androidx.recyclerview.widget
            .DefaultItemAnimator()
        recyclerView.layoutManager=androidx.recyclerview.widget
            .LinearLayoutManager(this)
        adaptador.notifyDataSetChanged()
    }

    fun aumentarTotalLikes() {
        totalLikes=totalLikes+1
        val totalLikesTextView=findViewById<TextView>(
            R.id.tv_total_likes

        )
        totalLikesTextView.text=totalLikes.toString()
    }
}