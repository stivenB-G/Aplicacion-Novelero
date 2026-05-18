package com.example.appnovelero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnovelero.databinding.ItemMetodoPagoBinding
import com.example.appnovelero.dominio.model.Payment

class MetodoPagoAdapter(
    private val metodos: List<Payment>,
    private val onSelected: (Payment) -> Unit,
    private val onDelete: (Payment) -> Unit
) : RecyclerView.Adapter<MetodoPagoAdapter.MetodoViewHolder>() {

    private var selectedPosition = metodos.indexOfFirst { it.es_predeterminado }

    class MetodoViewHolder(val binding: ItemMetodoPagoBinding) : 
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetodoViewHolder {
        val binding = ItemMetodoPagoBinding.inflate(
            LayoutInflater.from(parent.context), 
            parent, 
            false
        )
        return MetodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MetodoViewHolder, position: Int) {
        val metodo = metodos[position]
        
        with(holder.binding) {
            tvMetodoNombre.text = metodo.numero_enmascarado
            rbMetodoSeleccion.isChecked = position == selectedPosition
            
            if (metodo.icono_res_id != 0) {
                ivMetodoIcono.setImageResource(metodo.icono_res_id)
            }

            root.setOnClickListener {
                val oldPosition = selectedPosition
                selectedPosition = holder.adapterPosition
                notifyItemChanged(oldPosition)
                notifyItemChanged(selectedPosition)
                onSelected(metodo)
            }

            btnEliminarMetodo.setOnClickListener {
                onDelete(metodo)
            }
        }
    }

    override fun getItemCount(): Int = metodos.size
}
