package com.example.appnovelero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnovelero.databinding.ItemAdminUsuarioBinding
import com.example.appnovelero.dominio.model.User

class UsuarioAdminAdapter(
    private val usuarios: List<User>,
    private val onEditClick: (User) -> Unit,
    private val onDeleteClick: (User) -> Unit
) : RecyclerView.Adapter<UsuarioAdminAdapter.UsuarioViewHolder>() {

    class UsuarioViewHolder(val binding: ItemAdminUsuarioBinding) : 
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val binding = ItemAdminUsuarioBinding.inflate(
            LayoutInflater.from(parent.context), 
            parent, 
            false
        )
        return UsuarioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        
        with(holder.binding) {
            tvNombreAdminItem.text = usuario.nombre
            tvRolAdminItem.text = usuario.rol
            
            val context = holder.itemView.context
            if (usuario.rol.uppercase().contains("ADMIN") || usuario.rol.uppercase().contains("MODERADOR")) {
                tvRolAdminItem.setTextColor(context.getColor(com.example.appnovelero.R.color.novelero_accent))
                ivAvatarAdminItem.imageTintList = android.content.res.ColorStateList.valueOf(context.getColor(com.example.appnovelero.R.color.novelero_text_secondary))
            } else {
                tvRolAdminItem.setTextColor(context.getColor(com.example.appnovelero.R.color.novelero_muted))
                ivAvatarAdminItem.imageTintList = android.content.res.ColorStateList.valueOf(context.getColor(com.example.appnovelero.R.color.novelero_muted))
            }

            btnEditarUsuario.setOnClickListener { onEditClick(usuario) }
            btnEliminarUsuario.setOnClickListener { onDeleteClick(usuario) }
        }
    }

    override fun getItemCount(): Int = usuarios.size
}
