package com.example.listatelefone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listatelefone.R
import com.example.listatelefone.adapter.listener.ContatoOnClickListener
import com.example.listatelefone.adapter.viewholder.ContatoViewHolder
import com.example.listatelefone.model.Contato

class ContatoListAdapter(
    private val contatoList: List<Contato>,
    private val contatoOnClickListener: ContatoOnClickListener
) : RecyclerView.Adapter<ContatoViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        return ContatoViewHolder(
            LayoutInflater.from(parent.context). inflate(R.layout.row_contato, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return contatoList.size
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = contatoList[position]

        holder.textNome.text = contato.nome
        if (contato.imagemId>0){
            holder.image.setImageResource(contato.imagemId)
        }else{
            holder.image.setImageResource(R.drawable.profiledefault)
        }

        holder.itemView.setOnClickListener {
            contatoOnClickListener.clickListener(contato)
        }
    }
}