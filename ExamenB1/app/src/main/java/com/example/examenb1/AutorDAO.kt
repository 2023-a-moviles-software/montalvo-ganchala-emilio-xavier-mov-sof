package com.example.examenb1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.time.LocalDate

class AutorDAO(context: Context?) : DAO<Autor>(context) {

    override fun onCreate(db: SQLiteDatabase?) {
        val scriptSQLCrearTablaAutor =
            """
                CREATE TABLE AUTOR(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre VARCHAR(50),
                    apellido VARCHAR(50),
                    fechaNacimiento VARCHAR(50),
                    genero CHAR(1),
                    nacionalidad VARCHAR(50)
                )
            """.trimIndent()
        db?.execSQL(scriptSQLCrearTablaAutor)
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
        // Lógica de actualización de base de datos (si es necesario)
    }

    override fun add(autor: Autor) {
        val baseDatosEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("nombre", autor.getNombre())
        valoresAGuardar.put("apellido", autor.getApellido())
        valoresAGuardar.put("fechaNacimiento", autor.getFechaNacimiento().toString())
        valoresAGuardar.put("genero", autor.getGenero().toString())
        valoresAGuardar.put("nacionalidad", autor.getNacionalidad())

        baseDatosEscritura.insert("AUTOR", null, valoresAGuardar)
        baseDatosEscritura.close()
    }

    override fun delete(id: Int): Boolean {
        val conexionEscritura = writableDatabase
        val parametrosConsultaDelete = arrayOf(id.toString())
        val resultadoEliminacion = conexionEscritura.delete(
            "AUTOR",
            "id=?",
            parametrosConsultaDelete
        )
        conexionEscritura.close()
        return resultadoEliminacion != -1
    }

    override fun edit(autor: Autor) {
        val conexionEscritura = writableDatabase
        val valoresAActualizar = ContentValues()
        valoresAActualizar.put("nombre", autor.getNombre())
        valoresAActualizar.put("apellido", autor.getApellido())
        valoresAActualizar.put("fechaNacimiento", autor.getFechaNacimiento().toString())
        valoresAActualizar.put("genero", autor.getGenero().toString())
        valoresAActualizar.put("nacionalidad", autor.getNacionalidad())

        val parametrosConsultaActualizar = arrayOf(autor.getId().toString())
        val resultadoActualizacion = conexionEscritura.update(
            "AUTOR",
            valoresAActualizar,
            "id=?",
            parametrosConsultaActualizar
        )
        conexionEscritura.close()
    }

    override fun get(id: Int): Autor? {
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura = """
            SELECT * FROM AUTOR WHERE id = ?
        """.trimIndent()
        val parametrosConsultaLectura = arrayOf(id.toString())
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(
            scriptConsultaLectura,
            parametrosConsultaLectura
        )

        val autorEncontrado: Autor?
        if (resultadoConsultaLectura.moveToFirst()) {
            val id = resultadoConsultaLectura.getInt(0)
            val nombre = resultadoConsultaLectura.getString(1)
            val apellido = resultadoConsultaLectura.getString(2)
            val fechaNacimientoStr = resultadoConsultaLectura.getString(3)
            val genero = resultadoConsultaLectura.getString(4)
            val nacionalidad = resultadoConsultaLectura.getString(5)

            val fechaNacimiento = LocalDate.parse(fechaNacimientoStr)
            autorEncontrado = Autor(id, nombre, apellido, fechaNacimiento, genero[0], nacionalidad)
        } else {
            autorEncontrado = null
        }

        resultadoConsultaLectura.close()
        baseDatosLectura.close()

        return autorEncontrado
    }

    override fun getLista(): List<Autor> {
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura = """
            SELECT * FROM AUTOR
        """.trimIndent()

        val resultadoConsultaLectura = baseDatosLectura.rawQuery(
            scriptConsultaLectura,
            null
        )

        val listaAutores = mutableListOf<Autor>()

        while (resultadoConsultaLectura.moveToNext()) {
            val id = resultadoConsultaLectura.getInt(0)
            val nombre = resultadoConsultaLectura.getString(1)
            val apellido = resultadoConsultaLectura.getString(2)
            val fechaNacimientoStr = resultadoConsultaLectura.getString(3)
            val genero = resultadoConsultaLectura.getString(4)
            val nacionalidad = resultadoConsultaLectura.getString(5)

            val fechaNacimiento = LocalDate.parse(fechaNacimientoStr)
            val autor = Autor(id, nombre, apellido, fechaNacimiento, genero[0], nacionalidad)
            listaAutores.add(autor)
        }

        resultadoConsultaLectura.close()
        baseDatosLectura.close()

        return listaAutores
    }

    fun existe(id: Int): Boolean {
        return get(id) != null
    }
}