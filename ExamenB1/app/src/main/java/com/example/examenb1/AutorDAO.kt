package com.example.examenb1

class AutorDAO():DAO<Autor>(){


    override fun add(autor: Autor): Unit {
        val idUltimo= BDDMemoria.arregloAutor.last().getId()
        autor.setId(idUltimo+1);
       BDDMemoria.arregloAutor.add(autor)
    }
    override fun delete(id: Int): Boolean {
        return BDDMemoria.arregloAutor.removeIf { it.getId()==id }
    }

    override fun edit(autor: Autor){
        val indice=BDDMemoria.arregloAutor.indexOfFirst { it.getId()==autor.getId() }
        BDDMemoria.arregloAutor.set(indice,autor)
    }

    override fun get(id: Int):Autor?{

        return BDDMemoria.arregloAutor.firstOrNull { autor: Autor -> autor.getId() == id }
    }

    override fun getLista(): List<Autor>{

        return BDDMemoria.arregloAutor
    }

    fun existe(id: Int):Boolean{
        return BDDMemoria.arregloAutor.any { it.getId()==id }
    }
}