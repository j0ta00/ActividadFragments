package com.example.juanjomz.actividadfragments
import android.content.Context
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    val model: ViewModelContacto by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sizeScreen=findViewById<FragmentContainerView>(R.id.HostFrame)
        sizeScreen(sizeScreen)
        model.tipo.observe(this, Observer { _ ->
            if(sizeScreen!=null){
                supportFragmentManager.beginTransaction().replace(R.id.HostFrame,Fragmento_Informacion_Contactos()).addToBackStack("").commit()
            }
        })
    }
    private fun sizeScreen(sizeScreen:FragmentContainerView){
        if(sizeScreen==null){
            supportFragmentManager.beginTransaction().add(R.id.HostFrameBig,Fragmento_Informacion_Contactos()).commit()
        }

    }

}