import dao.AutorDAO
import dao.LibroDAO
import modelo.Autor
import modelo.Libro
import java.time.LocalDate

fun main(args: Array<String>) {

    val autor:Autor = Autor(1,"Emily", "Manuel", LocalDate.now(),'M',"peruano")
    val libro = Libro(5,"Naranja","Universo","2001","terror","ingles",1)

    val autorDAO = AutorDAO()
    val libroDAO = LibroDAO()


    libroDAO.edit(libro)



}