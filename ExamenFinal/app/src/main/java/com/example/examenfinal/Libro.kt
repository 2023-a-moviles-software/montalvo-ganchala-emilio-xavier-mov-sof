package com.example.examenfinal

import java.time.LocalDate

class Libro {
    private var id: Int=0
    private var titulo: String=""
    private var editorial=""
    private var fechaPublicacion: LocalDate? =null
    private var disponible: Boolean=true;
    private var precio: Double=0.00;
    private var idAutor=0

    constructor(id:Int, titulo:String, editorial:String, fechaPublicacion: LocalDate, disponible:Boolean, precio:Double, idAutor: Int){
        this.id=id
        this.titulo=titulo
        this.editorial=editorial
        this.fechaPublicacion=fechaPublicacion
        this.disponible=disponible
        this.precio=precio
        this.idAutor=idAutor
    }
}