package com.example.calculadoragridlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var txtResult: TextView
    var OpeEspera=false
    var Suma=false
    var Resta=false
    var numAnterior=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResult= findViewById(R.id.resultado)
    }
fun PresionoBotones(v:View){
    val btnPresion= v as TextView
    if(txtResult.text.equals("0")||OpeEspera) {
        txtResult.text = btnPresion.text
        OpeEspera = false
    }
    else
        txtResult.text="${txtResult.text}${btnPresion.text}"
}
    fun OpeEjecuta(){
        var numActual=txtResult.text.toString().toInt()
        var result =0
        if(Suma)
            result = numActual + numAnterior
        else if(Resta)
            result=numAnterior - numActual
        txtResult.text=result.toString()
    }
    fun PresionoOperacion(v: View){
        val btnPresion = v as TextView
        if (Suma||Resta)

            OpeEjecuta()
        OpeEspera=true
        when(btnPresion.text){
            "+"->{
                Suma=true
                Resta=false
                numAnterior=txtResult.text.toString().toInt()

            }
            "-"->{
                Suma=false
                Resta=true
                numAnterior=txtResult.text.toString().toInt()

            }
            "="->{
                Suma=false
                Resta=false
                numAnterior=0


            }
            "C"->{
                Suma=false
                Resta=false
                txtResult.text="0"
                numAnterior=0

            }
        }

    }

}