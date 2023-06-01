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
    calcularSueldo(20.00,12.00,20.0)
    calcularSueldo(20.00)

    val sumaUno=Suma(1,1)
    val sumados=Suma(null,1)
    val sumaTres=Suma(1,null)
    val sumaCuatro=Suma(null,null)

    sumaUno.sumar()
    sumados.sumar()
    sumaTres.sumar()
    sumaCuatro.sumar()
    println(Suma.pi)
    println(Suma.elevarAlCuadrado(2))
    println(Suma.historialSumas)
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
    protected val numeroDos: Int
){
    init {//bloque de constructor primario
        this.numeroUno; this.numeroDos;
        numeroUno; numeroDos;
        println("inicializado")
    }


}


class Suma(
    unoParametro: Int,
    dosParametros: Int
    ) : Numeros(unoParametro,dosParametros){//extendiendo y mandando parametros
    init {
        this.numeroUno
        this.numeroDos
    }

    constructor(uno: Int?, dos: Int):this(
        if(uno==null) 0 else uno, dos
    )

    constructor(uno: Int, dos: Int?):this(
        uno,if(dos==null) 0 else dos
    )

    constructor(uno: Int?, dos: Int?):this(
        if(uno==null) 0 else uno, if(dos==null) 0 else dos
    )

    public fun sumar(): Int{
        val total= numeroUno + numeroDos;
        agregarHistorial(total)
        return total
    }

    companion object{
        val pi=3.14
        fun elevarAlCuadrado(num: Int):Int{
            return num*num
        }
        val historialSumas = ArrayList<Int>()

        fun agregarHistorial(valorNuevaSuma:Int){
            historialSumas.add(valorNuevaSuma)
        }
    }

}