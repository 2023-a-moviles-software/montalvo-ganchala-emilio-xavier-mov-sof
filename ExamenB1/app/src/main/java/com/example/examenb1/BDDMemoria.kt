package com.example.examenb1

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class BDDMemoria {
    companion object{
        val arregloAutor= arrayListOf<Autor>()
        val arregloLibro= arrayListOf<Libro>()

        init {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")


            arregloAutor.add(Autor(1, "Isaac", "Asimov", LocalDate.parse("02/01/1920", formatter), 'M', "Estadounidense"))
            arregloAutor.add(Autor(2, "Philip K.", "Dick", LocalDate.parse("16/12/1928", formatter), 'M', "Estadounidense"))
            arregloAutor.add(Autor(3, "Arthur C.", "Clarke", LocalDate.parse("16/12/1917", formatter), 'M', "Británico"))
            arregloAutor.add(Autor(4, "Robert", "Heinlein", LocalDate.parse("07/07/1907", formatter), 'M', "Estadounidense"))


            arregloLibro.add(Libro(1, "Fundación", "Norma", LocalDate.parse("01/01/1951", formatter), true, 14.99, 1))
            arregloLibro.add(Libro(2, "¿Sueñan los androides con ovejas eléctricas?", "Norma", LocalDate.parse("02/06/1968", formatter), true, 14.99, 1))
            arregloLibro.add(Libro(3, "2001: Una odisea espacial", "Norma", LocalDate.parse("01/04/1968", formatter), true, 14.99, 1))
            arregloLibro.add(Libro(4, "Gato", "Norma", LocalDate.parse("01/01/2022", formatter), true, 14.99, 2))
            arregloLibro.add(Libro(5, "Perro", "Norma", LocalDate.parse("01/01/2023", formatter), true, 14.99, 2))


        }
    }
}