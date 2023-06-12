import dao.AutorDAO
import dao.LibroDAO
import modelo.Autor
import modelo.Libro
import java.time.LocalDate
import javax.swing.*


import javax.swing.JOptionPane


class Menu {

    private val autorDAO=AutorDAO()
    private val libroDAO= LibroDAO()



    fun mostrarMenu() {
        val opcionesPrincipal = arrayOf("Autor", "Libro", "Salir")

        var opcionPrincipalSeleccionada: Int

        do {
            opcionPrincipalSeleccionada = JOptionPane.showOptionDialog(
                null, "Seleccione una opción", "Menú Principal", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcionesPrincipal, opcionesPrincipal[0]
            )

            when (opcionPrincipalSeleccionada) {
                0 -> mostrarMenuAutor()
                1 -> mostrarMenuLibro()
                2 -> JOptionPane.showMessageDialog(null, "Saliendo del programa...")
                else -> JOptionPane.showMessageDialog(null, "Opción inválida")
            }
        } while (opcionPrincipalSeleccionada != 2)
    }

    private fun mostrarMenuAutor() {
        val opcionesAutor = arrayOf("Registrar Autor", "Actualizar Autor", "Consultar Autor", "Eliminar Autor", "Volver al Menú Principal")

        var opcionAutorSeleccionada: Int

        do {
            opcionAutorSeleccionada = JOptionPane.showOptionDialog(
                null, "Seleccione una opción", "Menú Autor", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcionesAutor, opcionesAutor[0]
            )

            when (opcionAutorSeleccionada) {
                0 -> registrarAutor()
                1 -> actualizarAutor()
                2 -> consultarAutor()
                3 -> eliminarAutor()
                4 -> JOptionPane.showMessageDialog(null, "Volviendo al Menú Principal...")
                else -> JOptionPane.showMessageDialog(null, "Opción inválida")
            }
        } while (opcionAutorSeleccionada != 4)
    }

    private fun mostrarMenuLibro() {
        val opcionesLibro = arrayOf("Registrar Libro", "Actualizar Libro", "Consultar Libro", "Eliminar Libro", "Volver al Menú Principal")

        var opcionLibroSeleccionada: Int

        do {
            opcionLibroSeleccionada = JOptionPane.showOptionDialog(
                null, "Seleccione una opción", "Menú Libro", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcionesLibro, opcionesLibro[0]
            )

            when (opcionLibroSeleccionada) {
                0 -> registrarLibro()
                1 -> actualizarLibro()
                2 -> consultarLibro()
                3 -> eliminarLibro()
                4 -> JOptionPane.showMessageDialog(null, "Volviendo al Menú Principal...")
                else -> JOptionPane.showMessageDialog(null, "Opción inválida")
            }
        } while (opcionLibroSeleccionada != 4)
    }

    private fun registrarAutor() {
        val autor = Autor(
            0,
                    (JOptionPane.showInputDialog("Ingrese el nombre del autor")),
                    (JOptionPane.showInputDialog("Ingrese el apellido del autor")),
                    (LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del autor (AAAA-MM-DD)"))),
                   (JOptionPane.showInputDialog("Ingrese el género del autor").first()),
                    (JOptionPane.showInputDialog("Ingrese la nacionalidad del autor")),


        )



        autorDAO.add(autor)
        JOptionPane.showMessageDialog(null, "Autor registrado exitosamente")
    }

    private fun actualizarAutor() {
        val id = JOptionPane.showInputDialog("Ingrese el ID del autor a actualizar")

        val autor = autorDAO.get(id)

        if (autor != null) {

                autor.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre del autor"))
                autor.setApellido(JOptionPane.showInputDialog("Ingrese el nuevo apellido del autor"))
                autor.setFechaNacimiento(LocalDate.parse(JOptionPane.showInputDialog("Ingrese la nueva fecha de nacimiento del autor (AAAA-MM-DD)")))
                autor.setGenero(JOptionPane.showInputDialog("Ingrese el nuevo género del autor").first())
                autor.setNacionalidad(JOptionPane.showInputDialog("Ingrese la nueva nacionalidad del autor"))
                autorDAO.edit(autor)
                JOptionPane.showMessageDialog(null, "Autor actualizado exitosamente")



        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un autor con el ID especificado")
        }
    }

    private fun consultarAutor() {
        val id = JOptionPane.showInputDialog("Ingrese el ID del autor a consultar")

        val autor = autorDAO.get(id)

        if (autor != null) {
            val mensaje = "ID: ${autor.getId()}\nNombre: ${autor.getNombre()}\nApellido: ${autor.getApellido()}" +
                    "\nFecha de Nacimiento: ${autor.getFechaNacimiento()}\nGénero: ${autor.getGenero()}" +
                    "\nNacionalidad: ${autor.getNacionalidad()}"

            JOptionPane.showMessageDialog(null, mensaje)
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un autor con el ID especificado")
        }
    }

    private fun eliminarAutor() {
        val id = JOptionPane.showInputDialog("Ingrese el ID del autor a eliminar")

        val autor = autorDAO.get(id)

        if (autor != null) {
            autorDAO.delete(id)
            JOptionPane.showMessageDialog(null, "Autor eliminado exitosamente")
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un autor con el ID especificado")
        }
    }

    private fun registrarLibro() {
        val libro = Libro(
            0,
            (JOptionPane.showInputDialog("Ingrese el título del libro")),
            (JOptionPane.showInputDialog("Ingrese la editorial del libro")),
            (LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de publicación del libro (AAAA-MM-DD)"))),
            (JOptionPane.showInputDialog("¿Está disponible el libro? (S/N)").equals("S", ignoreCase = true)),
            (JOptionPane.showInputDialog("Ingrese el precio del libro").toDouble()),
            (JOptionPane.showInputDialog("Ingrese el ID del autor del libro").toInt())

        )



        libroDAO.add(libro)
        JOptionPane.showMessageDialog(null, "Libro registrado exitosamente")
    }

    private fun actualizarLibro() {
        val id = JOptionPane.showInputDialog("Ingrese el ID del libro a actualizar")

        val libro = libroDAO.get(id)

        if (libro != null) {

            libro.setTitulo(JOptionPane.showInputDialog("Ingrese el nuevo título del libro"))
            libro.setEditorial(JOptionPane.showInputDialog("Ingrese la nueva editorial del libro"))
            libro.setFechaPublicacion(LocalDate.parse(JOptionPane.showInputDialog("Ingrese la nueva fecha de publicación del libro (AAAA-MM-DD)")))
            libro.setDisponible(JOptionPane.showInputDialog("¿Está disponible el libro? (S/N)").equals("S", ignoreCase = true))
            libro.setPrecio(JOptionPane.showInputDialog("Ingrese el nuevo precio del libro").toDouble())
            libro.setIdAutor(JOptionPane.showInputDialog("Ingrese el nuevo ID del autor del libro").toInt())

            libroDAO.edit(libro)

            JOptionPane.showMessageDialog(null, "Libro actualizado exitosamente")
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un libro con el ID especificado")
        }
    }

    private fun consultarLibro() {
        val id = JOptionPane.showInputDialog("Ingrese el ID del libro a consultar")

        val libro = libroDAO.get(id)

        if (libro != null) {
            val mensaje = "ID: ${libro.getId()}\nTítulo: ${libro.getTitulo()}\nEditorial: ${libro.getEditorial()}" +
                    "\nFecha de Publicación: ${libro.getFechaPublicacion()}\nDisponible: ${libro.getDisponible()}" +
                    "\nPrecio: ${libro.getPrecio()}\nID del Autor: ${libro.getIdAutor()}"

            JOptionPane.showMessageDialog(null, mensaje)
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un libro con el ID especificado")
        }
    }

    private fun eliminarLibro() {
        val id = JOptionPane.showInputDialog("Ingrese el ID del libro a eliminar")

        val libro = libroDAO.get(id)

        if (libro != null) {
            libroDAO.delete(id)
            JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente")
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un libro con el ID especificado")
        }
    }
}







