package com.example.examenb1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.time.LocalDate

class LibroDAO(context: Context?) : DAO<Libro>(context) {



    override fun add(libro: Libro) {

    }

    override fun delete(id: Int): Boolean {
        throw NotImplementedError("Este método será implementado más tarde")
    }

    override fun edit(libro: Libro) {
        throw NotImplementedError("Este método será implementado más tarde")
    }

    override fun get(id: Int): Libro? {
        throw NotImplementedError("Este método será implementado más tarde")
    }

    override fun getLista(): List<Libro> {
        throw NotImplementedError("Este método será implementado más tarde")
    }

    fun getLista(autorId: Int): List<Libro> {
        throw NotImplementedError("Este método será implementado más tarde")
    }
}
