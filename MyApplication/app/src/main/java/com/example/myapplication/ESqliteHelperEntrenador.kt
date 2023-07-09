package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ESqliteHelperEntrenador(contexto: Context?): SQLiteOpenHelper(contexto,"moviles",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun crearEntrenador(
        nombre: String,
        descripcion: String
    ):Boolean{
        val baseDatosEscritura = writableDatabase
        val valoresAGuardar=ContentValues()
        valoresAGuardar.put("nombre",nombre)
        valoresAGuardar.put("descripcion",descripcion)
        val resultadoGuardar=baseDatosEscritura.insert(
            "ENTRENADOR",
            null,
            valoresAGuardar
        )

        baseDatosEscritura.close()
        return if (resultadoGuardar.toInt()==-1)false else true

    }

    fun eliminarEntrenadorformulario(id:Int):Boolean{
        val conexionEscritura=writableDatabase
        //where Id=?
        val parametrosConsultaDelete= arrayOf(id.toString())

        val resultadoEliminacion=conexionEscritura.delete(
            "ENTRENADOR",
            "id=?",
            parametrosConsultaDelete
        )
        conexionEscritura.close()
        return if(resultadoEliminacion.toInt()==-1)false else true

    }

    fun actualizarEntrenadorFormulario(
        nombre: String,
        descripcion: String,
        id: Int,
    ):Boolean{
        val conexionEscritura=writableDatabase
        val valoresActualizar = ContentValues()
        valoresActualizar.put("nombre",nombre)
        valoresActualizar.put("descipcion",descripcion)
        //where Id = ?

        val parametrosConsulatActualizar=arrayOf(id.toString())
        val resultadoActualizacion=conexionEscritura.update(
            "Entrenador",
            valoresActualizar,
            "id=?",
            parametrosConsulatActualizar
        )
        conexionEscritura.close()
        return if(resultadoActualizacion.toInt()==-1) false else true


    }

    fun consultarentrenadorPorID(id: Int): BEntrenador{
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura="""
             SELECT * FROM Entrenador Where ID =?
        """.trimIndent()
       val parametrosConsultaLectura = arrayOf(id.toString())
        val resulradoConsultaLectura=baseDatosLectura.rawQuery(
            scriptConsultaLectura,
            parametrosConsultaLectura,
        )

        //logica busqueda
        val existeUsusario=resulradoConsultaLectura.moveToFirst()
        val usuarioencontrado=BEntrenador(0,"","")
        val arreglo = arrayListOf<BEntrenador>()
        if(existeUsusario){
            do{
                val id=resulradoConsultaLectura.getInt(0)
                val nombre=resulradoConsultaLectura.getString(1)
                val descripcion=resulradoConsultaLectura.getString(2)
                if(id!=null){
                    usuarioencontrado.id=id
                    usuarioencontrado.nombre=nombre
                    usuarioencontrado.descripcion=descripcion
                }
            }while (resulradoConsultaLectura.moveToNext())
        }
        resulradoConsultaLectura.close()
        baseDatosLectura.close()
        return usuarioencontrado






    }


}