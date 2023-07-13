package com.example.examenb1

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class BDDMemoria {
    companion object{
        val arregloAutor= arrayListOf<Autor>()
        val arregloLibro= arrayListOf<Libro>()

        init {
            arregloAutor.add(Autor(1,"Manuel","Lopez",LocalDate.now(),'M',"Peruano"))
            arregloAutor.add(Autor(2,"Manuel1","Lopez",LocalDate.now(),'M',"Peruano"))
            arregloAutor.add(Autor(3,"Manuel2","Lopez",LocalDate.now(),'F',"Peruano"))
            arregloAutor.add(Autor(5,"Manuel2","Lopez",LocalDate.now(),'F',"Peruano"))


            arregloLibro.add(Libro(1,"Metamorfosis","Norma", LocalDate.now(),true,14.99,1))
            arregloLibro.add(Libro(2,"Metamorfosis1","Norma", LocalDate.now(),true,14.99,1))
            arregloLibro.add(Libro(3,"Metamorfosis2","Norma", LocalDate.now(),true,14.99,1))
            arregloLibro.add(Libro(4,"Gato","Norma", LocalDate.now(),true,14.99,2))
            arregloLibro.add(Libro(5,"Perro","Norma", LocalDate.now(),true,14.99,2))

        }
    }
}