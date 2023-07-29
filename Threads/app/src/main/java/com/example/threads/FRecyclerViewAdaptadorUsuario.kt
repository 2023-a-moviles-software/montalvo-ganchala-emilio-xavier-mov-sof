package com.example.threads

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FRecyclerViewAdaptadorUsuario(
    private val contexto: MainActivity,
    private val lista: ArrayList<Usuario>,
    private val recyclerView: RecyclerView
) : RecyclerView.Adapter<FRecyclerViewAdaptadorUsuario.MyViewHolder>() {


    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var usuarioTextView: TextView=view.findViewById(R.id.tv_nombre_usuario_us)
        var descripcionTextView: TextView=view.findViewById(R.id.tv_descripcion)
        var seguidoresTextView: TextView=view.findViewById(R.id.tv_seguidores)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_view_vista_search,
            parent,
            false
        )
        return MyViewHolder(itemView)
    }

    // Setear datos
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val usuarioActual=this.lista[position]
        holder.usuarioTextView.text=usuarioActual.usuario
        holder.descripcionTextView.text=usuarioActual.usuarioUnico

    }

    override fun getItemCount(): Int {
        return this.lista.size
    }



}