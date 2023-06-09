package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

open class MainActivity : AppCompatActivity() {

    val callbackContenidoIntentExplicito=
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            result ->
            if(result.resultCode== Activity.RESULT_OK){
                if(result.data!=null){
                    val data = result.data
                   "${data?.getStringExtra("nombreModificado")}"
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        val botonCicloVida=findViewById<Button>(R.id.btn_ciclo_vida)
        EBaseDeDatos.tablaentrenador=ESqliteHelperEntrenador(this)
        botonCicloVida.setOnClickListener{
            //irActividad(ACicloVida::class.java)
            irActividad(AACicloVida::class.java)
        }

        val botonListView = findViewById<Button>(R.id.btn_ir_list_view)

        botonListView.setOnClickListener {
            irActividad(BListView::class.java)
        }

        val botonIntentImplicito = findViewById<Button>(R.id.btn_it_intent_implicito)

        botonIntentImplicito.setOnClickListener {
            val intentConRespuesta = Intent(
                Intent.ACTION_PICK,
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI
            )
        }

        val botonIntentExplicito = findViewById<Button>(R.id.btn_ir_intent_explicito)

        botonIntentExplicito.setOnClickListener {
           abrirActividadConParametros(CIntentExplicitoParametros::class.java)
        }

        val botonSqlite=findViewById<Button>(R.id.btn_sqlite)
        botonSqlite.setOnClickListener {
            irActividad(ECrudentrenador::class.java)
        }

        val botonRView=findViewById<Button>(R.id.btn_revcycler_view)
        botonRView.setOnClickListener {
            irActividad(FRecyclerView::class.java)
        }





        val callbackIntentPickUri=
            registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ){
                result ->
                if(result.resultCode == RESULT_OK){
                    if(result.data != null){
                        if(result.data!!.data != null){
                            val uri: Uri =result.data!!.data!!
                            val cursor = contentResolver.query(uri,null,null,null,null,null)
                            cursor?.moveToFirst()
                            val indiceTelefono = cursor?.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                            )
                            val telefono=cursor?.getString(indiceTelefono!!)
                            cursor?.close()
                            "Telefono ${telefono}"
                        }
                    }
                }

            }



    }
    fun irActividad(clase: Class<*>){
        val intent = Intent(this,clase)
        startActivity(intent)//si no se va a recibir datos
        //this.startActivity()
    }

    fun abrirActividadConParametros( clase: Class<*>)
    {
        val intentExplicito=Intent(this,clase)
        intentExplicito.putExtra("nombre","Adrian")
        intentExplicito.putExtra("apellido","Eguez")
        intentExplicito.putExtra("edad",30)

        callbackContenidoIntentExplicito.launch(intentExplicito)
    }

}