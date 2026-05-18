package com.example.appnovelero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.appnovelero.databinding.ItemLibroContinuacionBinding
import com.example.appnovelero.dominio.model.Book

class LibroContinuacionAdapter(
    private val libros: List<Book>,
    private val onItemClick: (Book) -> Unit
) : RecyclerView.Adapter<LibroContinuacionAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemLibroContinuacionBinding) : 
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLibroContinuacionBinding.inflate(
            LayoutInflater.from(parent.context), 
            parent, 
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val libro = libros[position]
        with(holder.binding) {
            tvTituloCont.text = libro.titulo
            tvVolumenCont.text = "Nuevo Volumen ${libro.volumen}"
            
            ivPortadaCont.load(libro.portada_url) {
                crossfade(true)
                placeholder(com.example.appnovelero.R.color.novelero_card)
            }
            
            root.setOnClickListener { onItemClick(libro) }
        }
    }

    override fun getItemCount(): Int = libros.size
}
