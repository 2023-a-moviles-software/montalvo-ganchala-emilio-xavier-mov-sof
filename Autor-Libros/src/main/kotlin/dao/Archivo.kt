package dao
import java.io.*
import java.nio.file.Paths


class Archivo {

    private val file: File

    constructor(nombreArchivo: String) {
        val path = Paths.get("src\\main\\resources\\$nombreArchivo").toAbsolutePath().toString()
        this.file = File(path)
        try {
            if (!file.exists()) {
                file.createNewFile()
            }
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    fun leerRegistros():Array<String>?{
        try {
            return file.useLines { it.toList().toTypedArray() }
        } catch (e: Exception) {
            println("Error al leer las líneas del archivo: ${e.message}")
        }
        return null

    }

    fun escribirRegistro(linea:String):Unit{
        try {

            //lee la ultima linea para agregar un id autoincremental
            val lineas = file.bufferedReader().readLines()
            var id="0"

            val ultimaLinea = lineas.lastOrNull()

            if (ultimaLinea != null && ultimaLinea!="") {

                val secciones = ultimaLinea.split(",")
                if (secciones.isNotEmpty()) {
                    id= (secciones[0].toInt()+1).toString()
                }
            }


            val fileWriter = FileWriter(file, true)
            val bufferedWriter = BufferedWriter(fileWriter)

            bufferedWriter.write(id+","+linea)
            bufferedWriter.newLine()
            bufferedWriter.close()
        } catch (e: Exception) {
            println("Error al escribir en el archivo: ${e.message}")
            e.printStackTrace()
        }
    }

    fun eliminarRegistro(id:String){
        try {

            val tempFile = File("temp.txt")

            val reader = BufferedReader(FileReader(file))
            val writer = FileWriter(tempFile)

            var currentLine: String?

            while (reader.readLine().also { currentLine = it } != null) {
                if (!currentLine!!.startsWith(id)) {
                    writer.write(currentLine)
                    writer.write(System.lineSeparator())
                }
            }

            writer.close()
            reader.close()

            if (file.delete()) {
                if (!tempFile.renameTo(file)) {
                    println("Error al renombrar el archivo temporal.")
                }
            } else {
                println("Error al eliminar el archivo original.")
            }
        } catch (e: Exception) {
            println("Error al eliminar las líneas: ${e.message}")
        }
    }


    fun getRegistro(id:String):String?{
        try {

            val lineas = file.bufferedReader().readLines()
            val registro = lineas.find { it.startsWith(id) }
            return registro;

        } catch (e: Exception) {
            println("Error al leer las líneas: ${e.message}")
        }

        return null;
    }

    fun getRegistrosPorClaveForanea(clave:String):List<String>{
           val registros = mutableListOf<String>()
            file.forEachLine { linea ->
                if (linea.endsWith(clave)) {
                    registros.add(linea)
                }
            }
        return registros;
    }

    fun editRegistro(id:String,nuevoContenido: String){

        val lineas = file.bufferedReader().readLines().toMutableList()
        val indiceLinea = lineas.indexOfFirst { it.startsWith(id) }
        if (indiceLinea != -1) {
            lineas[indiceLinea] = id+","+nuevoContenido
            file.bufferedWriter().use { writer ->
                for (linea in lineas) {
                    writer.write(linea)
                    writer.newLine()
                }
            }

        } else {

        }
    }



}