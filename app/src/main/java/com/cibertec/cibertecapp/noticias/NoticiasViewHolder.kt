package com.cibertec.cibertecapp.noticias

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class NoticiasViewHolder(inflater: LayoutInflater, parent: ViewGroup):
RecyclerView.ViewHolder(inflater.inflate(R.layout.item_noticia, parent,
    false)){

    private var imgPortada: ImageView? = null
    private var textTitulo: TextView? = null
    private var textContenido: TextView? = null

    init {
        imgPortada = itemView.findViewById(R.id.imgNoticiaPortada)
        textTitulo = itemView.findViewById(R.id.textNoticiaTitulo)
        textContenido = itemView.findViewById(R.id.textNoticiaContenido)
    }

    fun bind(noticia: Noticia) {
        textTitulo?.text = noticia.titulo
        textContenido?.text = noticia.contenido
        imgPortada?.setImageResource(noticia.portada) // Glide
    }

}