package dao


import modelo.Libro


class LibroDAO:DAO<Libro>(){
    companion object{
        private var listaLibros = mutableListOf<Libro>()
        val archivo:Archivo = Archivo("libros.txt")
    }

    override fun add(libro: Libro): Unit {
        archivo.escribirRegistro(libro.toString());
    }

    override fun delete(id: String): Unit {
        archivo.eliminarRegistro(id);
    }

    override fun edit(libro: Libro) {
        archivo.editRegistro(libro.getId().toString(),libro.toString())
    }

    override fun get(id: String): Libro? {
        val autorString= archivo.getRegistro(id);
        return if (autorString==null){
            null
        }else{
            Libro(autorString);
        }
    }

    override fun getLista(): List<Libro>? {
        val registros= archivo.leerRegistros()
        if(registros!=null){
            for(registro in registros ){
                listaLibros.add(Libro(registro))
            }
        }
        return listaLibros
    }

    fun getListaPorAutor(id: String): List<Libro>? {
        val registros= archivo.getRegistrosPorClaveForanea(id);
        if(registros!=null){
            for(registro in registros ){
                listaLibros.add(Libro(registro))
            }
        }
        return listaLibros
    }


}