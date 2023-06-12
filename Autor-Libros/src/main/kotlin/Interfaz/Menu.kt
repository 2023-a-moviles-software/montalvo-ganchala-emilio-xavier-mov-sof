import Interfaz.MenuCrud
import modelo.Autor
import java.awt.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.swing.*


class Menu: JFrame(){

    var ventana=0;

    val menuInicial= JPanel()
    val tituloMenu = JLabel("Menú")
    val btnAutores = JButton("Autores")
    val btnLibros = JButton("Libros")
    val btnSalir = JButton("Salir")



    init {

        this.title="Registro de Libros y Empleados";
        this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        //menu inicial-------------------------------------
        //configuracion
        menuInicial.layout = BoxLayout(menuInicial, BoxLayout.Y_AXIS)
        menuInicial.setSize(500, 500)
        menuInicial.alignmentX = Component.CENTER_ALIGNMENT

        //titulo
        tituloMenu.alignmentX = Component.CENTER_ALIGNMENT
        tituloMenu.font = tituloMenu.font.deriveFont(24f)
        menuInicial.add(tituloMenu)

        //boton autores
        btnAutores.addActionListener {

            menuCrud(1)

        }
        btnAutores.alignmentX = Component.CENTER_ALIGNMENT
        menuInicial.add(Box.createVerticalStrut(10))
        menuInicial.add(btnAutores)

        menuInicial.add(Box.createVerticalStrut(10))

        //boton libros
        btnLibros.addActionListener {

            menuCrud(2)
        }
        btnLibros.alignmentX = Component.CENTER_ALIGNMENT
        menuInicial.add(btnLibros)

        menuInicial.add(Box.createVerticalStrut(10))


        btnSalir.addActionListener {
            this.dispose()
        }
        btnSalir.alignmentX = Component.CENTER_ALIGNMENT
        menuInicial.add(btnSalir)



    }




    fun desplegar() {

        this.contentPane = menuInicial
        this.setLocationRelativeTo(null)
        this.setSize(250, 250)
        this.isVisible = true
    }
    fun menuCrud(ventana: Int){

        this.contentPane = MenuCrud(ventana,this, menuInicial);
        this.setSize(250, 300)
    }


}


