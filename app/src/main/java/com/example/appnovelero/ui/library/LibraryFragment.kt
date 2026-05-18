package com.example.appnovelero.ui.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appnovelero.R
import com.example.appnovelero.adapter.LibroBibliotecaAdapter
import com.example.appnovelero.databinding.FragmentBibliotecaBinding
import com.example.appnovelero.dominio.model.Book

class LibraryFragment : Fragment() {

    private var _binding: FragmentBibliotecaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBibliotecaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        
        binding.btnCart.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_biblioteca_to_navigation_carrito)
        }

        binding.btnBannerPremium.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_biblioteca_to_navigation_payment)
        }
    }

    private fun setupRecyclerView() {
        val listaLibros = listOf(
            Book(titulo = "Sombras del Destino Eterno", rating = 3.75),
            Book(titulo = "Neo-Tokio: Protocolo Zero", rating = 1.25),
            Book(titulo = "El Archivo de las Almas", rating = 5.0),
            Book(titulo = "La Torre de Marfil", rating = 4.5)
        )

        val adapter = LibroBibliotecaAdapter(listaLibros) { libro ->
            // Al tocar el libro, enviamos el título al lector
            val args = Bundle().apply {
                putString("titulo_libro", libro.titulo)
            }
            findNavController().navigate(R.id.action_navigation_biblioteca_to_navigation_lector, args)
        }

        binding.rvLibrosBiblioteca.apply {
            this.adapter = adapter
            layoutManager = GridLayoutManager(context, 2)
            isNestedScrollingEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
