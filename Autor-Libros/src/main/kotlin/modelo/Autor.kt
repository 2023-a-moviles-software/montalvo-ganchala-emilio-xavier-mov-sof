package modelo

import java.time.LocalDate
import java.time.format.DateTimeFormatter

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

    constructor(descripcion: String){

        val atributos = descripcion.split(",").map { it.trim() }
        if (atributos.size == 6) {
            this.id = atributos[0].toInt();
            this.nombre = atributos[1];
            this.apellido= atributos[2];
            val formatter = DateTimeFormatter.ISO_LOCAL_DATE
            this.fechaNacimiento= LocalDate.parse(atributos[3], formatter);
            this.genero= atributos[4].toCharArray()[0];
            this.nacionalidad= atributos[5];

        } else {
            println("No se proporcionaron suficientes atributos para inicializar el autor.")
        }

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

    override fun toString(): String {
        return "$nombre,$apellido,$fechaNacimiento,$genero,$nacionalidad"
    }


}