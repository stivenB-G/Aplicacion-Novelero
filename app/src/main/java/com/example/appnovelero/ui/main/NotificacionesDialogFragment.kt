package com.example.appnovelero.ui.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnovelero.adapter.NotificacionesAdapter
import com.example.appnovelero.databinding.DialogNotificacionesBinding
import com.example.appnovelero.dominio.model.Notification

class NotificacionesDialogFragment : DialogFragment() {

    private var _binding: DialogNotificacionesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogNotificacionesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        
        binding.btnCerrarNotif.setOnClickListener {
            dismiss()
        }
    }

    private fun setupRecyclerView() {
        val fakeNotif = listOf(
            Notification(mensaje = "¡Nuevo Volumen! Sombras del Reino Vol. 4 ya disponible.", fecha = "Hace 2 horas"),
            Notification(mensaje = "Diana Jimenez acaba de subir un nuevo capítulo.", fecha = "Hoy, 10:30 AM"),
            Notification(mensaje = "Tu novela favorita 'Neo-Tokio' tiene una actualización.", fecha = "Ayer")
        )
        
        binding.rvNotificaciones.apply {
            adapter = NotificacionesAdapter(fakeNotif)
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "NotificacionesDialog"
        fun newInstance() = NotificacionesDialogFragment()
    }
}
