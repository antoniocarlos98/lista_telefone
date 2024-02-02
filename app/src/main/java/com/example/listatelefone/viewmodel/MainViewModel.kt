package com.example.listatelefone.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.listatelefone.database.ContatoRepositorio
import com.example.listatelefone.model.Contato

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val listaContato: MutableLiveData<List<Contato>> = MutableLiveData(listOf())
    private val contatoRepositorio = ContatoRepositorio(application.applicationContext)

    fun listaContato(): LiveData<List<Contato>>{
        return listaContato
    }

    fun getListaContato(){
        listaContato.value = contatoRepositorio.selectAll()
    }
}