package com.example.examenb1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.time.LocalDate

class LibroDAO(context: Context?) : DAO<Libro>(context) {

    override fun onCreate(db: SQLiteDatabase?) {
        val crearTablaLibro =
            """
                CREATE TABLE LIBRO(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    titulo VARCHAR(50),
                    editorial VARCHAR(50),
                    fechaPublicacion VARCHAR(50),
                    disponible INTEGER,
                    precio REAL,
                    idAutor INTEGER
                )
            """.trimIndent()
        db?.execSQL(crearTablaLibro)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    override fun add(libro: Libro) {
        val baseDatosEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("titulo", libro.getTitulo())
        valoresAGuardar.put("editorial", libro.getEditorial())
        valoresAGuardar.put("fechaPublicacion", libro.getFechaPublicacion().toString())
        valoresAGuardar.put("disponible", if (libro.getDisponible()) 1 else 0)
        valoresAGuardar.put("precio", libro.getPrecio())
        valoresAGuardar.put("idAutor", libro.getIdAutor())

        baseDatosEscritura.insert("LIBRO", null, valoresAGuardar)
        baseDatosEscritura.close()
    }

    override fun delete(id: Int): Boolean {
        val conexionEscritura = writableDatabase
        val parametrosConsultaDelete = arrayOf(id.toString())
        val resultadoEliminacion = conexionEscritura.delete(
            "LIBRO",
            "id=?",
            parametrosConsultaDelete
        )
        conexionEscritura.close()
        return resultadoEliminacion != -1
    }

    override fun edit(libro: Libro) {
        val conexionEscritura = writableDatabase
        val valoresAActualizar = ContentValues()
        valoresAActualizar.put("titulo", libro.getTitulo())
        valoresAActualizar.put("editorial", libro.getEditorial())
        valoresAActualizar.put("fechaPublicacion", libro.getFechaPublicacion().toString())
        valoresAActualizar.put("disponible", if (libro.getDisponible()) 1 else 0)
        valoresAActualizar.put("precio", libro.getPrecio())
        valoresAActualizar.put("idAutor", libro.getIdAutor())

        val parametrosConsultaActualizar = arrayOf(libro.getId().toString())
        val resultadoActualizacion = conexionEscritura.update(
            "LIBRO",
            valoresAActualizar,
            "id=?",
            parametrosConsultaActualizar
        )
        conexionEscritura.close()
    }

    override fun get(id: Int): Libro? {
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura = """
            SELECT * FROM LIBRO WHERE id = ?
        """.trimIndent()
        val parametrosConsultaLectura = arrayOf(id.toString())
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(
            scriptConsultaLectura,
            parametrosConsultaLectura
        )

        val libroEncontrado: Libro?
        if (resultadoConsultaLectura.moveToFirst()) {
            val id = resultadoConsultaLectura.getInt(0)
            val titulo = resultadoConsultaLectura.getString(1)
            val editorial = resultadoConsultaLectura.getString(2)
            val fechaPublicacionStr = resultadoConsultaLectura.getString(3)
            val disponible = resultadoConsultaLectura.getInt(4) != 0
            val precio = resultadoConsultaLectura.getDouble(5)
            val idAutor = resultadoConsultaLectura.getInt(6)

            val fechaPublicacion = LocalDate.parse(fechaPublicacionStr)
            libroEncontrado = Libro(id, titulo, editorial, fechaPublicacion, disponible, precio, idAutor)
        } else {
            libroEncontrado = null
        }

        resultadoConsultaLectura.close()
        baseDatosLectura.close()

        return libroEncontrado
    }

    override fun getLista(): List<Libro> {
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura = """
            SELECT * FROM LIBRO
        """.trimIndent()

        val resultadoConsultaLectura = baseDatosLectura.rawQuery(scriptConsultaLectura, null)

        val arreglo = arrayListOf<Libro>()

        if (resultadoConsultaLectura.moveToFirst()) {
            do {
                val id = resultadoConsultaLectura.getInt(0)
                val titulo = resultadoConsultaLectura.getString(1)
                val editorial = resultadoConsultaLectura.getString(2)
                val fechaPublicacion = LocalDate.parse(resultadoConsultaLectura.getString(3))
                val disponible = resultadoConsultaLectura.getInt(4) != 0
                val precio = resultadoConsultaLectura.getDouble(5)
                val idAutor = resultadoConsultaLectura.getInt(6)

                val libroEncontrado = Libro(
                    id, titulo, editorial, fechaPublicacion, disponible, precio, idAutor
                )
                arreglo.add(libroEncontrado)
            } while (resultadoConsultaLectura.moveToNext())
        }

        resultadoConsultaLectura.close()
        baseDatosLectura.close()
        return arreglo
    }

    fun getLista(autorId: Int): List<Libro> {
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura = """
            SELECT * FROM LIBRO WHERE idAutor = ?
        """.trimIndent()

        val parametrosConsultaLectura = arrayOf(autorId.toString())
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(
            scriptConsultaLectura, parametrosConsultaLectura
        )

        val arreglo = arrayListOf<Libro>()

        if (resultadoConsultaLectura.moveToFirst()) {
            do {
                val id = resultadoConsultaLectura.getInt(0)
                val titulo = resultadoConsultaLectura.getString(1)
                val editorial = resultadoConsultaLectura.getString(2)
                val fechaPublicacion = LocalDate.parse(resultadoConsultaLectura.getString(3))
                val disponible = resultadoConsultaLectura.getInt(4) != 0
                val precio = resultadoConsultaLectura.getDouble(5)
                val idAutor = resultadoConsultaLectura.getInt(6)

                val libroEncontrado = Libro(
                    id, titulo, editorial, fechaPublicacion, disponible, precio, idAutor
                )
                arreglo.add(libroEncontrado)
            } while (resultadoConsultaLectura.moveToNext())
        }

        resultadoConsultaLectura.close()
        baseDatosLectura.close()
        return arreglo
    }
}
