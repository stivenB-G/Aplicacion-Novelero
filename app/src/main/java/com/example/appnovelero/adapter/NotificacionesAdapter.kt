package com.example.appnovelero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnovelero.databinding.ItemNotificacionBinding
import com.example.appnovelero.dominio.model.Notification

class NotificacionesAdapter(private val lista: List<Notification>) : 
    RecyclerView.Adapter<NotificacionesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemNotificacionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNotificacionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notif = lista[position]
        holder.binding.tvMensajeNotificacion.text = notif.mensaje
        holder.binding.tvFechaNotificacion.text = notif.fecha
    }

    override fun getItemCount(): Int = lista.size
}
