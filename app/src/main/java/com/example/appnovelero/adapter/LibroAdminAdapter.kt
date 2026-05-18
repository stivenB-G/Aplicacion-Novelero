package com.example.appnovelero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnovelero.databinding.ItemAdminLibroBinding
import com.example.appnovelero.dominio.model.Book

class LibroAdminAdapter(
    private val libros: List<Book>,
    private val onEditClick: (Book) -> Unit,
    private val onDeleteClick: (Book) -> Unit
) : RecyclerView.Adapter<LibroAdminAdapter.LibroViewHolder>() {

    class LibroViewHolder(val binding: ItemAdminLibroBinding) : 
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val binding = ItemAdminLibroBinding.inflate(
            LayoutInflater.from(parent.context), 
            parent, 
            false
        )
        return LibroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = libros[position]
        
        with(holder.binding) {
            tvTituloAdmin.text = libro.titulo
            tvAutorAdmin.text = "Autor: Novelero"
            tvVentasAdmin.text = "Ventas: ${libro.vistas / 100}" // Simulando ventas basadas en vistas
            
            btnEditarAdmin.setOnClickListener { onEditClick(libro) }
            btnEliminarAdmin.setOnClickListener { onDeleteClick(libro) }
        }
    }

    override fun getItemCount(): Int = libros.size
}
