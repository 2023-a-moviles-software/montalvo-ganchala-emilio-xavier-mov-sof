package com.example.threads

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val arreglo=BDDMemoria.arregloPublicaciones
    var posicion=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonHome=findViewById<ImageButton>(R.id.btn_home)
        val botonSearh=findViewById<ImageButton>(R.id.btn_search)


        //definir lista
        val recyclerView = findViewById<RecyclerView>(R.id.rv_publicaciones)

        val adaptador=FRecyclerViewAdaptadorPublicacion(
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

        //botones
        botonSearh.setOnClickListener {
            if (posicion==0){
                posicion=1
                botonSearh.setImageResource(R.drawable.search2)
                botonHome.setImageResource(R.drawable.home2)
            }
        }

        botonHome.setOnClickListener {
            if (posicion==1){
                posicion=0
                botonSearh.setImageResource(R.drawable.search)
                botonHome.setImageResource(R.drawable.home)

            }
        }



    }
}