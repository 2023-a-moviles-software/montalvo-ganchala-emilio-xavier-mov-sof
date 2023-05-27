package modelo

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Libro {
    private var id=0
    private var titulo=""
    private var editorial=""
    private var anioPublicacion=""
    private var genero=""
    private var idioma=""
    private var idAutor=0

    constructor(id:Int,titulo:String,editorial:String,anioPublicacion:String,genero:String,idioma:String,idAutor: Int){
        this.id=id
        this.titulo=titulo
        this.editorial=editorial
        this.anioPublicacion=anioPublicacion
        this.genero=genero
        this.idioma=idioma
        this.idAutor=idAutor
    }

    constructor(descripcion: String){

        val atributos = descripcion.split(",").map { it.trim() }
        if (atributos.size == 7) {
            this.id = atributos[0].toInt();
            this.titulo=atributos[1]
            this.editorial=atributos[2]
            this.anioPublicacion=atributos[3]
            this.genero=atributos[4]
            this.idioma=atributos[5]
            this.idAutor=atributos[6].toInt();

        } else {
            println("No se proporcionaron suficientes atributos para inicializar el autor.")
        }

    }

    fun getId(): Int{
        return this.id
    }

    override fun toString(): String {
        return "$titulo,$editorial,$anioPublicacion,$genero,$idioma,$idAutor"
    }


}