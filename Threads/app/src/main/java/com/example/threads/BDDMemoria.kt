package com.example.threads

class BDDMemoria {
    companion object{
        val arregloPublicaciones= arrayListOf<Publicacion>()
        val arregloUsuario= arrayListOf<Usuario>()

        init {
            //Usuarios
            val imagen = R.drawable.perfil_1
            arregloUsuario.add(Usuario(imagen,"manuel","manuel123",53))
            arregloUsuario.add(Usuario(imagen,"jose","jose123",55))
            arregloUsuario.add(Usuario(imagen,"antonio","antonio123",444))
            arregloUsuario.add(Usuario(imagen,"mateo","Mateo Josue",75))
            arregloUsuario.add(Usuario(imagen,"dayana","d.b145",2))
            arregloUsuario.add(Usuario(imagen,"emily","emi1457",1))
            arregloUsuario.add(Usuario(imagen,"daniel","josekiller",424))
            arregloUsuario.add(Usuario(imagen,"erick","erick.123",424))
            arregloUsuario.add(Usuario(imagen,"azul","negro",888))
            arregloUsuario.add(Usuario(imagen, "carlos", "carlos123", 40))
            arregloUsuario.add(Usuario(imagen, "ana", "ana456", 32))
            arregloUsuario.add(Usuario(imagen, "luis", "luis789", 28))
            arregloUsuario.add(Usuario(imagen, "maría", "maria321", 26))
            arregloUsuario.add(Usuario(imagen, "pablo", "pablo654", 37))
            arregloUsuario.add(Usuario(imagen, "laura", "laura987", 24))
            arregloUsuario.add(Usuario(imagen, "javier", "javier741", 31))
            arregloUsuario.add(Usuario(imagen, "sofía", "sofia852", 29))
            arregloUsuario.add(Usuario(imagen, "hugo", "hugo963", 33))
            arregloUsuario.add(Usuario(imagen, "valentina", "valentina369", 22))
            arregloUsuario.add(Usuario(imagen, "alejandro", "alejandro258", 27))
            arregloUsuario.add(Usuario(imagen, "isabel", "isabel147", 30))
            arregloUsuario.add(Usuario(imagen, "martín", "martin753", 35))
            arregloUsuario.add(Usuario(imagen, "paula", "paula456", 31))
            arregloUsuario.add(Usuario(imagen, "felipe", "felipe951", 29))
            arregloUsuario.add(Usuario(imagen, "camila", "camila357", 26))
            arregloUsuario.add(Usuario(imagen, "andrés", "andres852", 34))
            arregloUsuario.add(Usuario(imagen, "carolina", "carolina741", 36))
            arregloUsuario.add(Usuario(imagen, "gabriel", "gabriel963", 25))
            arregloUsuario.add(Usuario(imagen, "renata", "renata369", 23))
            arregloUsuario.add(Usuario(imagen, "emily", "Emily369", 23))





            //Publicaciones
            arregloPublicaciones.add(Publicacion(arregloUsuario[0],"Buenos Días",R.drawable.publicacion_1,5,5,5))
            arregloPublicaciones.add(Publicacion(arregloUsuario[0],"Hola a todos",R.drawable.publicacion_1,5,5,5))
            arregloPublicaciones.add(Publicacion(arregloUsuario[1],"Adios a todos",R.drawable.publicacion_1,12,1,4))
            arregloPublicaciones.add(Publicacion(arregloUsuario[1],"como estan",R.drawable.publicacion_1,12,1,4))
        }
    }
}