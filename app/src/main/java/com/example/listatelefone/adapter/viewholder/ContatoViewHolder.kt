package com.example.listatelefone.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listatelefone.R

class ContatoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val image: ImageView = view.findViewById(R.id.image_foto)
    val textNome:TextView = view.findViewById(R.id.text_nome)
}