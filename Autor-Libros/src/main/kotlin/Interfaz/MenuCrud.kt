package Interfaz

import modelo.Autor
import java.awt.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.swing.*

class MenuCrud(ventana:Int,frame:JFrame,anterior:JPanel): JPanel() {

    val frame=frame
    val tituloMenuCrud = JLabel("Menú")
    val btnRegistrar = JButton("Registrar")
    val btnConsultar = JButton("Consultar")
    val btnActualizar = JButton("Actualizar")
    val btnEliminar = JButton("Eliminar")
    val btnAtras = JButton("Atrás")

    init {

        when(ventana){
            (1)->{
                tituloMenuCrud.text="Autores"
            }
            (2)->{
                tituloMenuCrud.text="Libros"
            }
        }


        //Menu Crud------------------------------------------------
        this.layout = BoxLayout(this, BoxLayout.Y_AXIS)
        this.setSize(500, 500)
        this.alignmentX = Component.CENTER_ALIGNMENT

        //titulo
        tituloMenuCrud.alignmentX = Component.CENTER_ALIGNMENT
        tituloMenuCrud.font = tituloMenuCrud.font.deriveFont(24f)
        this.add(tituloMenuCrud)

        //boton registrar
        btnRegistrar.addActionListener {

            when(ventana){
                (1)->{
                    registroAutores()
                }
                (2)->{
                    registroLibros()
                }
            }


        }
        btnRegistrar.alignmentX = Component.CENTER_ALIGNMENT
        this.add(Box.createVerticalStrut(10))
        this.add(btnRegistrar)

        this.add(Box.createVerticalStrut(10))

        //boton consultar
        btnConsultar.addActionListener {

            when(ventana){
                (1)->{
                    consultarAutores()
                }
                (2)->{
                    consultarLibros()
                }
            }
        }
        btnConsultar.alignmentX = Component.CENTER_ALIGNMENT
        this.add(Box.createVerticalStrut(10))
        this.add(btnConsultar)

        this.add(Box.createVerticalStrut(10))

        //boton actualizar
        btnActualizar.addActionListener {

            when(ventana){
                (1)->{
                    actualizarAutores()
                }
                (2)->{
                    actualizarLibros()
                }
            }


        }


        btnActualizar.alignmentX = Component.CENTER_ALIGNMENT
        this.add(Box.createVerticalStrut(10))
        this.add(btnActualizar)

        this.add(Box.createVerticalStrut(10))

        //boton eliminar
        btnEliminar.addActionListener {

            when(ventana){
                (1)->{
                    actualizarAutores()
                }
                (2)->{
                    actualizarLibros()
                }
            }


        }


        btnEliminar.alignmentX = Component.CENTER_ALIGNMENT
        this.add(Box.createVerticalStrut(10))
        this.add(btnEliminar)

        this.add(Box.createVerticalStrut(10))

        //boton atras
        btnAtras.addActionListener {
            frame.contentPane=anterior
        }

        btnAtras.alignmentX = Component.CENTER_ALIGNMENT
        this.add(btnAtras)
    }

    private fun actualizarLibros() {
        TODO("Not yet implemented")
    }

    private fun actualizarAutores() {
        TODO("Not yet implemented")
    }

    private fun consultarLibros() {
        TODO("Not yet implemented")
    }

    private fun consultarAutores() {
        TODO("Not yet implemented")
    }

    fun registroAutores(){

        this.frame.contentPane=RegistroAutores(frame,this)

    }

    private fun registroLibros() {
        TODO("Not yet implemented")
    }
}