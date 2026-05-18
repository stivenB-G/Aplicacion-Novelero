package com.example.appnovelero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnovelero.databinding.ItemLibroBibliotecaBinding
import com.example.appnovelero.dominio.model.Book

class LibroBibliotecaAdapter(
    private val libros: List<Book>,
    private val onItemClick: (Book) -> Unit
) : RecyclerView.Adapter<LibroBibliotecaAdapter.LibroViewHolder>() {

    class LibroViewHolder(val binding: ItemLibroBibliotecaBinding) : 
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val binding = ItemLibroBibliotecaBinding.inflate(
            LayoutInflater.from(parent.context), 
            parent, 
            false
        )
        return LibroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = libros[position]
        
        with(holder.binding) {
            tvTituloBiblioteca.text = libro.titulo
            tvAutorBiblioteca.text = "Novela"
            
            //Porcenteje simulado
            val porcentaje = (libro.rating * 20).toInt()
            tvProgresoTexto.text = "$porcentaje% leído"
            pbProgresoBarra.progress = porcentaje
            
            root.setOnClickListener { onItemClick(libro) }
        }
    }

    override fun getItemCount(): Int = libros.size
}
