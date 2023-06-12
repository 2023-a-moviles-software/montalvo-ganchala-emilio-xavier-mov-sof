package Interfaz

import dao.AutorDAO
import modelo.Autor
import java.awt.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.swing.*

class RegistroAutores(frame: JFrame, anterior: JPanel): JPanel() {

    val btnRegistrar = JButton("Registrar")
    val btnAtras = JButton("Atrás")
    val nombreField = JTextField(20)
    val apellidoField = JTextField(20)
    val fechaNacimientoField = JTextField(20)
    val generoField = JTextField(20)
    val nacionalidadField = JTextField(20)

    init{

        this.layout = BoxLayout(this, BoxLayout.Y_AXIS)
        this.name="Registro de Autores"



        this.add(JLabel("Nombre:"))
        this.add(nombreField)
        this.add(JLabel("Apellido:"))
        this.add(apellidoField)
        this.add(JLabel("Fecha de Nacimiento (YYYY-MM-DD):"))
        /*panel.add(JDateChooser())*/
        this.add(JLabel("Género:"))
        this.add(generoField)
        this.add(JLabel("Nacionalidad:"))
        this.add(nacionalidadField)

        //boton eliminar
        btnRegistrar.addActionListener {
            registrar()
        }


        btnRegistrar.alignmentX = Component.CENTER_ALIGNMENT
        this.add(Box.createVerticalStrut(10))
        this.add(btnRegistrar)

        this.add(Box.createVerticalStrut(10))

        //boton atras
        btnAtras.addActionListener {
            frame.contentPane=anterior
        }

        btnAtras.alignmentX = Component.CENTER_ALIGNMENT
        this.add(btnAtras)

    }

    private fun registrar() {
        val nombre = nombreField.text
        val apellido = apellidoField.text
        val fechaNacimientoStr = fechaNacimientoField.text
        val fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ISO_LOCAL_DATE)
        val genero = generoField.text[0]
        val nacionalidad = nacionalidadField.text

        val autor = Autor(0, nombre, apellido, fechaNacimiento, genero, nacionalidad)
        AutorDAO().add(autor)


    }


}