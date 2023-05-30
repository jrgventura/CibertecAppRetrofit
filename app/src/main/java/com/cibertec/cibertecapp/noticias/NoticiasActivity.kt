package com.cibertec.cibertecapp.noticias

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class NoticiasActivity: AppCompatActivity() {

    val listNoticias = listOf(
        Noticia("Noticia 01", "Contenido 01", R.drawable.noticias01),
        Noticia("Noticia 02", "Contenido 02", R.drawable.noticias02),
        Noticia("Noticia 03", "Contenido 03", R.drawable.noticias03)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        val recyclerNoticias = findViewById<RecyclerView>(R.id.recyclerNoticias)
        recyclerNoticias.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NoticiasAdapter(listNoticias)
        }

    }

}