package com.example.examenfinal

import java.time.LocalDate

class Autor{
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
}
