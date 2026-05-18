package com.example.appnovelero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.appnovelero.databinding.ItemLibroExplorarBinding
import com.example.appnovelero.dominio.model.Book

class LibroExplorarAdapter(
    private var libros: List<Book>,
    private val onItemClick: ((Book) -> Unit)? = null
) : RecyclerView.Adapter<LibroExplorarAdapter.LibroViewHolder>() {

    class LibroViewHolder(val binding: ItemLibroExplorarBinding) : 
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val binding = ItemLibroExplorarBinding.inflate(
            LayoutInflater.from(parent.context), 
            parent, 
            false
        )
        return LibroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = libros[position]
        
        with(holder.binding) {
            tvTituloItem.text = libro.titulo
            tvAutorItem.text = "Novela" // Por ahora, ya que autor_id es un código
            tvPrecioItem.text = "${libro.precio.toInt()} CRÉDITOS"
            tvGeneroItem.text = libro.genero
            tvRatingItem.text = libro.rating.toString()
            tvVistasItem.text = formatVistas(libro.vistas)
            
            ivPortadaItem.load(libro.portada_url) {
                crossfade(true)
                placeholder(com.example.appnovelero.R.color.novelero_card)
            }
            
            root.setOnClickListener { onItemClick?.invoke(libro) }
        }
    }

    override fun getItemCount(): Int = libros.size

    fun updateList(nuevaLista: List<Book>) {
        this.libros = nuevaLista
        notifyDataSetChanged()
    }

    private fun formatVistas(vistas: Int): String {
        return when {
            vistas >= 1000000 -> "${vistas / 1000000}M"
            vistas >= 1000 -> "${vistas / 1000}k"
            else -> vistas.toString()
        }
    }
}
