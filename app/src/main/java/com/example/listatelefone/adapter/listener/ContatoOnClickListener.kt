package com.example.listatelefone.adapter.listener

import com.example.listatelefone.model.Contato

class ContatoOnClickListener (val clickListener: (contato: Contato)-> Unit){
    fun onClick(contato: Contato) = clickListener
}