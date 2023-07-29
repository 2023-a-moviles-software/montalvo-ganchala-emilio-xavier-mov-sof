package com.example.threads

import kotlin.random.Random

class BDDMemoria {
    companion object{
        val arregloPublicaciones= arrayListOf<Publicacion>()
        val arregloUsuario= arrayListOf<Usuario>()

        init {
            //Usuarios
            val imagen = arrayOf(R.drawable.perfil_0, R.drawable.perfil_1, R.drawable.perfil_2,
                R.drawable.perfil_3, R.drawable.perfil_4, R.drawable.perfil_5, R.drawable.perfil_6)

            val random = Random(System.currentTimeMillis())
            val indiceAleatorio = random.nextInt(imagen.size)

            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)],"manuel","manuel123",53))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)],"jose","jose123",55))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)],"antonio","antonio123",444))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)],"mateo","Mateo Josue",75))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)],"dayana","d.b145",2))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)],"emily","emi1457",1))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)],"daniel","josekiller",424))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)],"erick","erick.123",424))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)],"azul","negro",888))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "carlos", "carlos123", 40))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "ana", "ana456", 32))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "luis", "luis789", 28))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "maría", "maria321", 26))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "pablo", "pablo654", 37))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "laura", "laura987", 24))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "javier", "javier741", 31))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "sofía", "sofia852", 29))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "hugo", "hugo963", 33))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "valentina", "valentina369", 22))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "alejandro", "alejandro258", 27))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "isabel", "isabel147", 30))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "martín", "martin753", 35))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "paula", "paula456", 31))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "felipe", "felipe951", 29))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "camila", "camila357", 26))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "andrés", "andres852", 34))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "carolina", "carolina741", 36))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "gabriel", "gabriel963", 25))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "renata", "renata369", 23))
            arregloUsuario.add(Usuario(imagen[random.nextInt(imagen.size)], "emily", "Emily369", 23))





            //Publicaciones
            arregloPublicaciones.add(Publicacion(arregloUsuario[0],"Buenos Días",R.drawable.publicacion_0,2,10,2))
            arregloPublicaciones.add(Publicacion(arregloUsuario[0],"Hola a todos",R.drawable.publicacion_0,5,5,5))
            arregloPublicaciones.add(Publicacion(arregloUsuario[1],"Adios a todos",R.drawable.publicacion_0,12,1,4))
            arregloPublicaciones.add(Publicacion(arregloUsuario[1],"Jajajajaja",R.drawable.publicacion_0,12,1,4))
            arregloPublicaciones.add(Publicacion(arregloUsuario[1],"Header",R.drawable.publicacion_0,12,1,4))
        }
    }
}