package com.example.examenb1

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Autor{
    var idfirebase:String = ""
    private var id: Int = 0
    private var nombre: String = ""
    private var apellido: String = ""
    private var fechaNacimiento: LocalDate? =null
    private var genero: Char = '\u0000'
    private var nacionalidad: String = ""

    constructor(id:Int,nombre:String,apellido:String,fechaNacimiento: LocalDate,genero: Char,nacionalidad: String){
        this.id = id
        this.nombre = nombre
        this.apellido= apellido
        this.fechaNacimiento=fechaNacimiento
        this.genero= genero
        this.nacionalidad= nacionalidad
    }

    fun getId(): Int{
        return this.id
    }

    fun getNombre():String{
        return this.nombre
    }

    fun getApellido():String{
        return this.apellido
    }

    fun getfechaNacimiento():LocalDate?{
        return this.fechaNacimiento
    }

    fun getGenero():Char{
        return this.genero
    }

    fun getNacionalidad(): String{
        return this.nacionalidad
    }


    fun setId(id: Int) {
        this.id = id
    }


    fun setNombre(nombre: String) {
        this.nombre = nombre
    }


    fun setApellido(apellido: String) {
        this.apellido = apellido
    }

    fun getFechaNacimiento(): LocalDate? = fechaNacimiento
    fun setFechaNacimiento(fechaNacimiento: LocalDate) {
        this.fechaNacimiento = fechaNacimiento
    }


    fun setGenero(genero: Char) {
        this.genero = genero
    }


    fun setNacionalidad(nacionalidad: String) {
        this.nacionalidad = nacionalidad
    }



    override fun toString(): String {
        return "Id:$id\nNombre:$nombre $apellido\nNacimiento:${
            fechaNacimiento!!.format(
            DateTimeFormatter.ofPattern("dd/MM/yyyy"))}\nGénero:$genero\nNacionalidad:$nacionalidad\n"
    }
}