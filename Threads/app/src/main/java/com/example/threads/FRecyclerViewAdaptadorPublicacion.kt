package com.example.threads

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FRecyclerViewAdaptadorPublicacion(
    private val contexto: MainActivity,
    private val lista: ArrayList<Publicacion>,
    private val recyclerView: RecyclerView
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TIPO_ENCABEZADO = 0
    private val TIPO_NORMAL = 1

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Variables de vistas para los elementos normales
        val usuarioTextView: TextView = view.findViewById(R.id.tv_nombre_usuario)
        val publicacionTextView: TextView = view.findViewById(R.id.tv_texto_publicacion)
        val respuestasTextView: TextView = view.findViewById(R.id.tv_respuestas)
        val megustaTextView: TextView = view.findViewById(R.id.tv_megusta)
        val horasTextView: TextView = view.findViewById(R.id.tv_horas)
    }

    inner class EncabezadoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Variables de vistas para el encabezado

    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TIPO_ENCABEZADO
        } else {
            TIPO_NORMAL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TIPO_ENCABEZADO -> {
                val headerView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.header, parent, false)
                EncabezadoViewHolder(headerView)
            }
            else -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_vista, parent, false)
                MyViewHolder(itemView)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TIPO_ENCABEZADO) {

        } else {
            val posicionReal = position - 1
            val publicacionActual = lista[posicionReal]
            val myViewHolder = holder as MyViewHolder
            myViewHolder.publicacionTextView.text = publicacionActual.texto
            myViewHolder.usuarioTextView.text = publicacionActual.usuario.usuario
            myViewHolder.megustaTextView.text = "${publicacionActual.likes} me gusta"
            myViewHolder.respuestasTextView.text = "${publicacionActual.respuestas} respuestas"
            myViewHolder.horasTextView.text = "5 h"
        }
    }

    override fun getItemCount(): Int {

        return lista.size
    }
}

