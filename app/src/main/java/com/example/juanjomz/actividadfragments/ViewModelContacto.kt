package com.example.juanjomz.actividadfragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelContacto:ViewModel(){
    val selected = MutableLiveData<Contacto>()
    val tipo = MutableLiveData<String>()

    fun select(contacto:Contacto) {
        selected.postValue(contacto)
    }
}