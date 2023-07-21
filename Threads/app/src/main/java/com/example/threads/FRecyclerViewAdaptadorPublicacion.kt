package com.example.threads

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FRecyclerViewAdaptadorPublicacion(
    private val cotexto: MainActivity,
    private val lista: ArrayList<Publicacion>,
    private val recyclerView: RecyclerView
):RecyclerView.Adapter<FRecyclerViewAdaptadorPublicacion.MyViewHolder>() {
    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val usuarioTextView: TextView
        val usuarioImageView: ImageView
        val publicacionTextView: TextView
        val publicacionImageView: ImageView
        //val respuestasImageView: ImageView
        val respuestasTextView:TextView
        val megustaTextView:TextView
        val horasTextView:TextView


        init {
            usuarioTextView=view.findViewById(R.id.tv_nombre_usuario)
            usuarioImageView=view.findViewById(R.id.imv_usuario)
            publicacionTextView=view.findViewById(R.id.tv_texto_publicacion)
            publicacionImageView=view.findViewById(R.id.imv_publicacion)
            //respuestasImageView=view.findViewById(R.id.imv_respuestas)
            respuestasTextView=view.findViewById(R.id.tv_respuestas)
            megustaTextView=view.findViewById(R.id.tv_megusta)
            horasTextView=view.findViewById(R.id.tv_horas)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_view_vista,
            parent,
            false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val publicacionActual=this.lista[position]
        holder.publicacionTextView.text=publicacionActual.texto
        holder.usuarioTextView.text=publicacionActual.usuario.usuario
        holder.megustaTextView.text="${publicacionActual.likes} me gusta"
        holder.publicacionImageView.setImageResource(publicacionActual.imagen)
        holder.usuarioImageView.setImageResource(publicacionActual.usuario.imagen)
        holder.respuestasTextView.text="${publicacionActual.respuestas} respuestas"


    }

    override fun getItemCount(): Int {
        return this.lista.size
    }
}