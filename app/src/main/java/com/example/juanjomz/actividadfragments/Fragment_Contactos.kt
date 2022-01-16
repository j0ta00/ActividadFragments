package com.example.juanjomz.actividadfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import com.example.juanjomz.actividadfragments.databinding.FragmentContactosBinding
import com.example.juanjomz.actividadfragments.databinding.RowLayoutBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_Contactos.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_Contactos : Fragment() {

    val contactos=listOf(
        Contacto("JAMNO","D","3435445345","3"),
        Contacto("DFASDF","E","78943545747","FG"),
        Contacto("LEPOR","R","9876543","UKELELE"),
        Contacto("JAMNO","D","3435445345","3"),
        Contacto("DFASDF","E","78943545747","FG"),
        Contacto("LEPOR","R","9876543","UKELELE"),
        Contacto("JAMNO","D","3435445345","3"),
        Contacto("DFASDF","E","78943545747","FG"),
        Contacto("LEPOR","R","9876543","UKELELE"),
        Contacto("JAMNO","D","3435445345","3"),
        Contacto("DFASDF","E","78943545747","FG"),
        Contacto("LEPOR","R","9876543","UKELELE"),
        Contacto("LEPOR","R","9876543","UKELELE"),
        Contacto("JAMNO","D","3435445345","3"),
        Contacto("DFASDF","E","78943545747","FG"),
        Contacto("LEPOR","R","9876543","UKELELE"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val rootView=FragmentContactosBinding.inflate(inflater, container, false).root
        val recyclerView=rootView.findViewById<RecyclerView>(R.id.rcvContactos)
        recyclerView?.layoutManager= LinearLayoutManager(rootView.context)
        recyclerView?.adapter= AdaptadorContacto(contactos)
        // Inflate the layout for this fragment
        return rootView
    }


    class AdaptadorContacto(val contactos: List<Contacto>):RecyclerView.Adapter<AdaptadorContacto.MyViewHolder>(){

        class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){
            val binding=RowLayoutBinding.bind(view)
            fun render(contacto:Contacto){
                binding.nombreContacto.text=contacto.nombre
                binding.numeroContacto.text=contacto.numero
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val layoutInflater= LayoutInflater.from(parent.context)
            return MyViewHolder(layoutInflater.inflate(R.layout.row_layout,parent,false))
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.render(contactos[position])
        }

        override fun getItemCount(): Int = contactos.size
    }
}