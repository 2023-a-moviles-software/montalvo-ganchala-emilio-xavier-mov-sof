package com.example.examenb1

import android.content.Context
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import java.time.LocalDate


class AutorDAO(context: Context?) : DAO<Autor>(context) {
    private val databaseReference: CollectionReference =  Firebase.firestore.collection("autores")
    companion object{
        var listaLocal= mutableListOf<Autor>()

    }
    override fun add(autor: Autor) {

            autor.setId((System.currentTimeMillis() % 100000).toInt()) // Usar el setter para establecer el ID.
            val autorData = HashMap<String, Any>()
            autorData["nombre"] = autor.getNombre()
            autorData["apellido"] = autor.getApellido()
            autorData["fechaNacimiento"] = autor.getFechaNacimiento().toString()
            autorData["genero"] = autor.getGenero().toString()
            autorData["nacionalidad"] = autor.getNacionalidad()

            databaseReference.document(autor.getId().toString())
                .set(autorData)
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

    override fun edit(autor: Autor) {

        val autorData = HashMap<String, Any>()
        autorData["nombre"] = autor.getNombre()
        autorData["apellido"] = autor.getApellido()
        autorData["fechaNacimiento"] = autor.getFechaNacimiento().toString()
        autorData["genero"] = autor.getGenero().toString()
        autorData["nacionalidad"] = autor.getNacionalidad()

        databaseReference.document(autor.getId().toString())
            .set(autorData)
            .addOnSuccessListener {  }
            .addOnFailureListener {  }
    }

    override fun get(id: Int): Autor? {
        var autorAux:Autor?=null
        databaseReference.document(id.toString()).get().addOnSuccessListener{document ->
            val data = document.data
            val autorA= Autor(
                document.id.toInt(),
                data?.get("nombre") as String,
                data.get("apellido") as String,
                LocalDate.parse(data.get("fechaNacimiento") as String),
                (data.get("genero") as String)[0],
                data.get("nacionalidad") as String
            )
            autorAux=autorA
        }.addOnFailureListener{

        }

        if (autorAux==null){
            autorAux=listaLocal.find { it.getId()==id }
        }

        return autorAux
    }

    override fun getLista(): MutableList<Autor> {


        val listaAutores:MutableList<Autor> = mutableListOf<Autor>()
        databaseReference.get().addOnSuccessListener {
            documents ->
            for (document in documents){
                val data = document.data

                val autorAux= Autor(
                    document.id.toInt(),
                    data.get("nombre") as String,
                    data.get("apellido") as String,
                    LocalDate.parse(data.get("fechaNacimiento") as String),
                    (data.get("genero") as String)[0],
                    data.get("nacionalidad") as String
                )

                listaAutores.add(autorAux)
            }
            listaLocal=listaAutores
        }.addOnFailureListener{ex ->
            println( ex.toString())

        }
        println("******************************************")
        println( listaAutores.size)


        return listaLocal
    }

    fun existe(id: Int): Boolean {
        var flag=false;
        databaseReference.document(id.toString())
            .delete()
            .addOnSuccessListener { flag=true }
            .addOnFailureListener {  }
        return flag
    }


}


