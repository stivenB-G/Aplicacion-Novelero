package com.example.appnovelero.ui.admin

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.appnovelero.databinding.DialogAdminAgregarUsuarioBinding

class AddUserDialogFragment : DialogFragment() {

    private var _binding: DialogAdminAgregarUsuarioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogAdminAgregarUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Hacer el fondo del diálogo transparente para que se vea el CardView redondeado
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnCerrarDialogo.setOnClickListener {
            dismiss()
        }

        binding.btnCancelar.setOnClickListener {
            dismiss()
        }

        binding.btnGuardar.setOnClickListener {
            // Aquí iría la lógica para guardar el usuario
            dismiss()
        }
        
        binding.layoutUploadImage.setOnClickListener {
            // Lógica para seleccionar imagen
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "AddUserDialogFragment"
        fun newInstance() = AddUserDialogFragment()
    }
}
