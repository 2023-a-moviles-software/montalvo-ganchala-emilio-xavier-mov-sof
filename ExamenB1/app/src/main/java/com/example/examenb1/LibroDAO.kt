package com.example.examenb1

class LibroDAO():DAO<Libro>(){


    override fun add(libro: Libro): Unit {
        val idUltimo= BDDMemoria.arregloLibro.last().getId()
        libro.setId(idUltimo+1);
        BDDMemoria.arregloLibro.add(libro)
    }
    override fun delete(id: Int): Boolean {
        return BDDMemoria.arregloLibro.removeIf { it.getId()==id }
    }

    override fun edit(libro: Libro){
        val indice=BDDMemoria.arregloLibro.indexOfFirst { it.getId()==libro.getId() }
        BDDMemoria.arregloLibro.set(indice,libro)
    }

    override fun get(id: Int):Libro?{

        return BDDMemoria.arregloLibro.firstOrNull { libro: Libro -> libro.getId() == id }
    }

    override fun getLista(): List<Libro>{

        return BDDMemoria.arregloLibro
    }

    fun getLista(autorId:Int):List<Libro>{
        return BDDMemoria.arregloLibro.filter { it.getIdAutor()==autorId}
    }
}