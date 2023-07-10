package com.example.examenb1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FReciclerViewAdaptadorAutor(
    private val contexto: MainActivity,
    private val lista: ArrayList<Autor>,
    private val recyclerView: RecyclerView
): RecyclerView.Adapter<FReciclerViewAdaptadorAutor.MyViewHolder>() {
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nombreTextView: TextView
        val apellidoTextView: TextView

        val botonEliminar: Button

        val botonEditar: Button
        val botonVerLibros: Button


        init {
            nombreTextView = view.findViewById(R.id.tv_nombre)
            apellidoTextView = view.findViewById(R.id.tv_apellido_rv)
            botonEliminar = view.findViewById(R.id.btn_editar)
            botonEditar = view.findViewById(R.id.btn_editar)
            botonVerLibros = view.findViewById(R.id.btn_ver_libros)
            botonEliminar.setOnClickListener { eliminar()}
            botonEditar.setOnClickListener { editar()  }
            botonVerLibros.setOnClickListener { verLibros()  }
        }

        fun eliminar(){

        }

        fun editar(){
            contexto.irActividad(FormularioAutor::class.java)
        }

        fun verLibros(){
            contexto.irActividad(FormularioLibro::class.java)
        }


    }

    // Setear el layout que vamos a usar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context)
            .inflate(
                R.layout.recycler_view_vista,
                parent,
                false
            )
        return MyViewHolder(itemView)
    }
    // Setear datos iteracion al iniciar el adaptador
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val autorActual = this.lista[position]
        holder.nombreTextView.text = autorActual.getNombre()
        holder.apellidoTextView.text = autorActual.getApellido()

    }

    // tamano del arreglo
    override fun getItemCount(): Int {
        return this.lista.size
    }
}
