package com.example.threads

class BDDMemoria {
    companion object{
        val arregloPublicaciones= arrayListOf<Publicacion>()
        val arregloUsuario= arrayListOf<Usuario>()

        init {
            arregloUsuario.add(Usuario(R.drawable.perfil_1,"manuel","manuel123"))
            arregloPublicaciones.add(Publicacion(arregloUsuario[0],"Hola a todos",R.drawable.publicacion_1,5,5,5))
        }
    }
}