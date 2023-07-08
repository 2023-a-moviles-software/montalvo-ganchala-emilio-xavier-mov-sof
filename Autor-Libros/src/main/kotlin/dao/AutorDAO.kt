package dao

import modelo.Autor

class AutorDAO():DAO<Autor>(){

    companion object{
        private var listaAutores = mutableListOf<Autor>()
        val archivo:Archivo = Archivo("autores.txt")
    }

    override fun add(autor: Autor): Unit {
        archivo.escribirRegistro(autor.toString());
    }
    override fun delete(id: String): Unit {
       archivo.eliminarRegistro(id);
    }

    override fun edit(autor: Autor){
        archivo.editRegistro(autor.getId().toString(),autor.toString())
    }

    override fun get(id: String):Autor?{

        val autorString=archivo.getRegistro(id);
        return if (autorString==null){
            null
        }else{
            Autor(autorString);
        }
    }

    override fun getLista(): List<Autor>?{
        val registros=archivo.leerRegistros()
        if(registros!=null){
            for(registro in registros ){
                listaAutores.add(Autor(registro))
            }
        }
        return listaAutores
    }





}