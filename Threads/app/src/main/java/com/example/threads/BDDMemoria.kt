package com.example.threads

class BDDMemoria {
    companion object{
        val arregloPublicaciones= arrayListOf<Publicacion>()
        val arregloUsuario= arrayListOf<Usuario>()

        init {
            arregloUsuario.add(Usuario(R.drawable.perfil_1,"manuel","manuel123"))
            arregloUsuario.add(Usuario(R.drawable.perfil_1,"jose","jose123"))
            arregloPublicaciones.add(Publicacion(arregloUsuario[0],"Encabezado",R.drawable.publicacion_1,5,5,5))
            arregloPublicaciones.add(Publicacion(arregloUsuario[0],"Hola a todos",R.drawable.publicacion_1,5,5,5))
            arregloPublicaciones.add(Publicacion(arregloUsuario[0],"Adios a todos",R.drawable.publicacion_1,12,1,4))
            arregloPublicaciones.add(Publicacion(arregloUsuario[1],"como estan",R.drawable.publicacion_1,12,1,4))
        }
    }
}