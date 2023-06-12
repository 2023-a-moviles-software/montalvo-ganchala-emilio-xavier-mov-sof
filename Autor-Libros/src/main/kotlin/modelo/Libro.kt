package modelo

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

    constructor(descripcion: String){

        val atributos = descripcion.split(",").map { it.trim() }
        if (atributos.size == 7) {
            this.id = atributos[0].toInt();
            this.titulo=atributos[1]
            this.editorial=atributos[2]
            val formatter = DateTimeFormatter.ISO_LOCAL_DATE
            this.fechaPublicacion=LocalDate.parse(atributos[3], formatter);
            this.disponible=atributos[4].toBoolean();
            this.precio=atributos[5].toDouble();
            this.idAutor=atributos[6].toInt();

        } else {
            println("No se proporcionaron suficientes atributos para inicializar el autor.")
        }

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

    fun getDiponible(): Boolean{
        return this.disponible
    }

    fun getPrecio():Double{
        return this.precio
    }

    fun getIdAutor():Int{
        return this.idAutor
    }


    override fun toString(): String {
        return "$titulo,$editorial,$fechaPublicacion,$disponible,$precio,$idAutor"
    }


}