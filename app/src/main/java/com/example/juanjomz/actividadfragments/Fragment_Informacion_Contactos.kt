package com.example.juanjomz.actividadfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.juanjomz.actividadfragments.databinding.ActivityMainBinding.inflate
import com.example.juanjomz.actividadfragments.databinding.FragmentContactosBinding
import com.example.juanjomz.actividadfragments.databinding.FragmentInformacionContactosBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragmento_Informacion_Contactos.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragmento_Informacion_Contactos : Fragment() {


    private val model: ViewModelContacto by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView=FragmentInformacionContactosBinding.inflate(inflater, container, false).root

        return inflater.inflate(R.layout.fragment_informacion_contactos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.selected.observe(this, Observer {_->
            onContactoChanged(view)
        })
    }

    fun onContactoChanged(view: View){
        view.findViewById<TextView>(R.id.nombre).text=model.selected.value?.nombre
        view.findViewById<TextView>(R.id.apellidos).text=model.selected.value?.apellidos
        view.findViewById<TextView>(R.id.telefono).text=model.selected.value?.numero
        view.findViewById<TextView>(R.id.direccion).text=model.selected.value?.direccion
    }

}