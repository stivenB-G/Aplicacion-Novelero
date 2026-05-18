package com.example.appnovelero.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appnovelero.R
import com.example.appnovelero.databinding.FragmentLectorBinding

class ReaderFragment : Fragment() {

    private var _binding: FragmentLectorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLectorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Recibimos el nombre del libro del Bundle
        arguments?.let { bundle ->
            val titulo = bundle.getString("titulo_libro") ?: "Lectura"
            binding.tvTituloBarraLector.text = titulo.uppercase()
        }

        binding.btnVolverLector.setOnClickListener {
            // Regresamos a la biblioteca
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
