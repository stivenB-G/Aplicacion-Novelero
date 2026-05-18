package com.example.appnovelero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.appnovelero.databinding.ItemLibroHorizontalBinding
import com.example.appnovelero.dominio.model.Book

class LibroHorizontalAdapter(
    private val libros: List<Book>,
    private val onItemClick: (Book) -> Unit
) : RecyclerView.Adapter<LibroHorizontalAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemLibroHorizontalBinding) : 
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLibroHorizontalBinding.inflate(
            LayoutInflater.from(parent.context), 
            parent, 
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val libro = libros[position]
        with(holder.binding) {
            tvTituloHorizontal.text = libro.titulo
            tvSubtituloHorizontal.text = "${libro.genero} • Novedad"
            
            ivPortadaHorizontal.load(libro.portada_url) {
                crossfade(true)
                placeholder(com.example.appnovelero.R.color.novelero_card)
            }
            
            root.setOnClickListener { onItemClick(libro) }
        }
    }

    override fun getItemCount(): Int = libros.size
}
