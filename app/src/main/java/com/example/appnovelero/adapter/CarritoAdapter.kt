package com.example.appnovelero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnovelero.databinding.ItemCarritoBinding
import com.example.appnovelero.dominio.model.CartItem

class CarritoAdapter(
    private val items: List<CartItem>,
    private val onRemoveClick: (CartItem) -> Unit
) : RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder>() {

    class CarritoViewHolder(val binding: ItemCarritoBinding) : 
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val binding = ItemCarritoBinding.inflate(
            LayoutInflater.from(parent.context), 
            parent, 
            false
        )
        return CarritoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        val item = items[position]
        
        with(holder.binding) {
            tvTituloCarrito.text = item.libro.titulo
            tvAutorCarrito.text = "Novela Digital"
            tvPrecioCarrito.text = "$ ${item.libro.precio.toInt()} COP"
            
            btnEliminarCarrito.setOnClickListener { onRemoveClick(item) }
        }
    }

    override fun getItemCount(): Int = items.size
}
