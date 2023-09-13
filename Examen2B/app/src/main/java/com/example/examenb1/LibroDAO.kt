package com.example.examenb1

import android.content.Context
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDate

class LibroDAO(context: Context?) : DAO<Libro>(context) {

    private val databaseReference: CollectionReference =  Firebase.firestore.collection("libros")
    companion object{
        var listaLocalLibros= mutableListOf<Libro>()
        var listaLocalLibroAutor= mutableListOf<Libro>()
    }

    override fun add(libro: Libro) {
        libro.setId((System.currentTimeMillis() % 100000).toInt()) // Usar el setter para establecer el ID.
        val libroData = HashMap<String, Any>()
        libroData["titulo"] = libro.getTitulo()
        libroData["editorial"] = libro.getEditorial()
        libroData["fechaPublicacion"] = libro.getFechaPublicacion().toString()
        libroData["disponible"] = libro.getDisponible().toString()
        libroData["precio"] = libro.getPrecio().toString()
        libroData["idAutor"] = libro.getIdAutor().toString()


        databaseReference.document(libro.getId().toString())
            .set(libroData)
            .addOnSuccessListener {  }
            .addOnFailureListener {  }
    }

    override fun delete(id: Int): Boolean {
        var flag=false;
        databaseReference.document(id.toString())
            .delete()
            .addOnSuccessListener { flag=true }
            .addOnFailureListener {  }
        return true
    }

    override fun edit(libro: Libro) {
        val libroData = HashMap<String, Any>()
        libroData["titulo"] = libro.getTitulo()
        libroData["editorial"] = libro.getEditorial()
        libroData["fechaPublicacion"] = libro.getFechaPublicacion().toString()
        libroData["disponible"] = libro.getDisponible().toString()
        libroData["precio"] = libro.getPrecio().toString()
        libroData["idAutor"] = libro.getIdAutor().toString()


        databaseReference.document(libro.getId().toString())
            .set(libroData)
            .addOnSuccessListener {  }
            .addOnFailureListener {  }
    }

    override fun get(id: Int): Libro? {
        var libroAux:Libro?=null
        databaseReference.document(id.toString()).get().addOnSuccessListener{document ->
            val data = document.data
            val libroA= Libro(
                document.id.toInt(),
                data?.get("titulo") as String,
                data.get("editorial") as String,
                LocalDate.parse(data.get("fechaPublicacion") as String),
                (data.get("disponible") as String).toBoolean(),
                (data.get("precio") as String).toDouble(),
                (data.get("idAutor") as String).toInt()
            )
            libroAux=libroA
        }.addOnFailureListener{

        }

        if (libroAux==null){
            libroAux= listaLocalLibros.find { it.getId()==id }
        }

        if (libroAux==null){
            libroAux= listaLocalLibroAutor.find { it.getId()==id }
        }

        return libroAux
    }

    override fun getLista(): MutableList<Libro> {
        val listaLibros:MutableList<Libro> = mutableListOf<Libro>()
        databaseReference.get().addOnSuccessListener {
                documents ->
            for (document in documents){
                val data = document.data
                val libroAux= Libro(
                    document.id.toInt(),
                    data?.get("titulo") as String,
                    data.get("editorial") as String,
                    LocalDate.parse(data.get("fechaPublicacion") as String),
                    (data.get("disponible") as String).toBoolean(),
                    (data.get("precio") as String).toDouble(),
                    (data.get("idAutor") as String).toInt()
                )

                listaLibros.add(libroAux)
            }
            listaLocalLibros =listaLibros
        }.addOnFailureListener{ex ->
            println( ex.toString())

        }

        return listaLocalLibros
    }

    fun getLista(autorId: Int): List<Libro> {
        val listaLibros:MutableList<Libro> = mutableListOf<Libro>()
        databaseReference.whereEqualTo("idAutor",autorId.toString()).get().addOnSuccessListener {
                documents ->
            for (document in documents){
                val data = document.data
                val libroAux= Libro(
                    document.id.toInt(),
                    data?.get("titulo") as String,
                    data.get("editorial") as String,
                    LocalDate.parse(data.get("fechaPublicacion") as String),
                    (data.get("disponible") as String).toBoolean(),
                    (data.get("precio") as String).toDouble(),
                    (data.get("idAutor") as String).toInt()
                )

                listaLibros.add(libroAux)
            }
            listaLocalLibroAutor =listaLibros
        }.addOnFailureListener{ex ->
            println( ex.toString())

        }

        return listaLocalLibroAutor
    }
}
