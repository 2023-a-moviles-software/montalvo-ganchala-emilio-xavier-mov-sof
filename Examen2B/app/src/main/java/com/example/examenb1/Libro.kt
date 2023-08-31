package com.example.examenb1

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Libro {
    private var id: Int=0
    private var titulo: String=""
    private var editorial=""
    private var fechaPublicacion: LocalDate? =null
    private var disponible: Boolean=true;
    private var precio: Double=0.00;
    private var idAutor=0

    constructor(id:Int, titulo:String, editorial:String, fechaPublicacion:LocalDate, disponible:Boolean, precio:Double, idAutor: Int){
        this.id=id
        this.titulo=titulo
        this.editorial=editorial
        this.fechaPublicacion=fechaPublicacion
        this.disponible=disponible
        this.precio=precio
        this.idAutor=idAutor
    }

    fun getId(): Int{
        return this.id
    }

    fun getTitulo(): String{
        return this.titulo
    }

    fun getEditorial(): String{
        return this.editorial
    }

    fun getFechaPublicacion(): LocalDate?{
        return this.fechaPublicacion
    }

    fun getDisponible(): Boolean{
        return this.disponible
    }

    fun getPrecio():Double{
        return this.precio
    }

    fun getIdAutor():Int{
        return this.idAutor
    }


    fun setId(id: Int) {
        this.id = id
    }


    fun setTitulo(titulo: String) {
        this.titulo = titulo
    }


    fun setEditorial(editorial: String) {
        this.editorial = editorial
    }


    fun setFechaPublicacion(fechaPublicacion: LocalDate) {
        this.fechaPublicacion = fechaPublicacion
    }


    fun setDisponible(disponible: Boolean) {
        this.disponible = disponible
    }


    fun setPrecio(precio: Double) {
        this.precio = precio
    }


    fun setIdAutor(idAutor: Int) {
        this.idAutor = idAutor
    }


    override fun toString(): String {
        return "id:$id\nTítulo$titulo\nEditorial:$editorial\nPublicación:${
            fechaPublicacion!!.format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy"))}\nDispobible:${if(disponible) "si" else "no"}\nPrecio:$precio\n"
    }
}