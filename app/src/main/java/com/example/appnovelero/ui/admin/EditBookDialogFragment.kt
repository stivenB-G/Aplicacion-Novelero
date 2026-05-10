package com.example.appnovelero.ui.admin

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.appnovelero.databinding.DialogAdminEditarLibroBinding

class EditBookDialogFragment : DialogFragment() {

    private var _binding: DialogAdminEditarLibroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogAdminEditarLibroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Fondo transparente para ver las esquinas redondeadas del CardView
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnCerrarDialogo.setOnClickListener {
            dismiss()
        }

        binding.btnGuardarCambios.setOnClickListener {
            // Lógica para guardar cambios
            dismiss()
        }

        binding.layoutCambiarPortada.setOnClickListener {
            // Lógica para cambiar imagen
        }

        binding.btnAnadirGenero.setOnClickListener {
            val nuevoGenero = binding.etNuevoGenero.text.toString()
            if (nuevoGenero.isNotEmpty()) {
                // Lógica para añadir chip (opcional para maqueta)
                binding.etNuevoGenero.text.clear()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "EditBookDialogFragment"
        fun newInstance() = EditBookDialogFragment()
    }
}
