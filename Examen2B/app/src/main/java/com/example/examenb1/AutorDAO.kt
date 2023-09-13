package com.example.examenb1

import android.content.Context
import com.google.firebase.database.*

class AutorDAO(context: Context?) : DAO<Autor>(context) {
    private val databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance().getReference("autores")

    override fun add(autor: Autor) {
        val autorId = databaseReference.push().key
        if (autorId != null) {
            autor.setId(autorId.toInt()) // Usar el setter para establecer el ID.
            val autorData = HashMap<String, Any>()
            autorData["nombre"] = autor.getNombre()
            autorData["apellido"] = autor.getApellido()
            autorData["fechaNacimiento"] = autor.getFechaNacimiento().toString()
            autorData["genero"] = autor.getGenero()
            autorData["nacionalidad"] = autor.getNacionalidad()

            databaseReference.child(autorId).setValue(autorData)
        }
    }

    override fun delete(id: Int): Boolean {
        val autorId = id.toString()
        databaseReference.child(autorId).removeValue()
        // Aquí podrías agregar lógica adicional para manejar el resultado de eliminación si es necesario.
        return true
    }

    override fun edit(autor: Autor) {
        val autorId = autor.getId().toString()
        val autorMap = HashMap<String, Any>()
        autorMap["nombre"] = autor.getNombre()
        autorMap["apellido"] = autor.getApellido()
        autorMap["fechaNacimiento"] = autor.getFechaNacimiento().toString()
        autorMap["genero"] = autor.getGenero().toString()
        autorMap["nacionalidad"] = autor.getNacionalidad()

        databaseReference.child(autorId).updateChildren(autorMap)
    }

    override fun get(id: Int): Autor? {
        val autorId = id.toString()
        var autorEncontrado: Autor? = null

        databaseReference.child(autorId).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val autorData = dataSnapshot.getValue(Autor::class.java)
                if (autorData != null) {
                    autorEncontrado = autorData
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Maneja errores aquí
            }
        })

        return autorEncontrado
    }

    override fun getLista(): List<Autor> {
        val listaAutores = mutableListOf<Autor>()

        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val autorData = snapshot.getValue(Autor::class.java)
                    if (autorData != null) {
                        listaAutores.add(autorData)
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Maneja errores aquí
            }
        })

        return listaAutores
    }

    fun existe(id: Int): Boolean {
        val autorId = id.toString()
        var existeAutor = false

        databaseReference.child(autorId).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                existeAutor = dataSnapshot.exists()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Maneja errores aquí
            }
        })

        return existeAutor
    }
}


