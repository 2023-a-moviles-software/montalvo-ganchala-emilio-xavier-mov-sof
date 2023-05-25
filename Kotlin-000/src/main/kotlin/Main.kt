fun main(args: Array<String>) {
    println("Hello World!")

    val inmutable: String = "Adrian";
    var mutable: String = "Hola";

    //val > var

    var ejemploVariable = " Adrian Eguez "
    val edadEjemplo: Int = 12
    ejemploVariable.trim()


    //variable primitiva
    val nombreProfessor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'C'

    //switch

    val estadoCivilWhen = "C"

    when (estadoCivilWhen){
        ("C") -> {
            println("Casado")
        }
        "S" -> {
            println("Soltero")
        }
        else ->{
            println("No sabemos")
        }
    }

    val esSoltero = (estadoCivilWhen == "S")
    val coqueteo = if (esSoltero) "Si" else "No"
    calcularSueldo(20.00)
}

fun imprimirNombre(nombre: String): Unit{
    println("Nombre : ${nombre}") //agregar la variable en el string
}

fun calcularSueldo(
    sueldo: Double,  //requerido
    tasa: Double = 12.00, //opcional
    bonoEspecial: Double?=null //Opcion null
):Double{

    if(bonoEspecial==null){
        return sueldo * (100/tasa)
    }else{
        return sueldo * (100/tasa) + bonoEspecial
    }
}

abstract class NumerosJava{
    protected val numeroUno: Int
    private val numeroDos: Int

    constructor(uno: Int,dos:Int){
        this.numeroUno=uno
        this.numeroDos=dos
        println("Inicializado")
    }
}

abstract class Numeros(
    protected val numeroUno: Int,
    private val numeroDos: Int
){
    init {//bloque de constructor primario
        this.numeroUno; this.numeroDos;
        numeroUno; numeroDos;
        println("inicializado")
    }


}