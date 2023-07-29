package com.example.threads

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FRecyclerViewAdaptadorUsuario(
    private val contexto: MainActivity,
    private val lista: ArrayList<Usuario>,
    private val recyclerView: RecyclerView
) : RecyclerView.Adapter<FRecyclerViewAdaptadorUsuario.MyViewHolder>() {


    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val usuarioTextView: TextView=view.findViewById(R.id.tv_nombre_usuario_us)
        val descripcionTextView: TextView=view.findViewById(R.id.tv_descripcion)
        val seguidoresTextView: TextView=view.findViewById(R.id.tv_seguidores)
        val perfilImageView:ImageView=view.findViewById(R.id.imv_perfil_foto)
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
        holder.perfilImageView.setImageResource(usuarioActual.imagen)
        holder.seguidoresTextView.text="${usuarioActual.seguidores.toString()} seguidores"
    }

    override fun getItemCount(): Int {
        return this.lista.size
    }



}