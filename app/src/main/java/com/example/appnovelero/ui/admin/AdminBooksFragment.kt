package com.example.appnovelero.ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnovelero.R
import com.example.appnovelero.adapter.LibroAdminAdapter
import com.example.appnovelero.databinding.FragmentAdminLibrosBinding
import com.example.appnovelero.dominio.model.Book

class AdminBooksFragment : Fragment() {

    private var _binding: FragmentAdminLibrosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminLibrosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        
        binding.btnAddNovel.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_admin_libros_to_navigation_add_novel)
        }
    }

    private fun setupRecyclerView() {
        val listaLibros = listOf(
            Book(titulo = "Sombras del Reino", vistas = 24000),
            Book(titulo = "Ecos del Destino", vistas = 12000),
            Book(titulo = "La Torre de Marfil", vistas = 8000),
            Book(titulo = "Protocolo Zero", vistas = 45000),
            Book(titulo = "Cielo de Ceniza", vistas = 15000)
        )

        val adapter = LibroAdminAdapter(
            listaLibros,
            onEditClick = { libro ->
                Toast.makeText(context, "Editando: ${libro.titulo}", Toast.LENGTH_SHORT).show()
            },
            onDeleteClick = { libro ->
                Toast.makeText(context, "Eliminando: ${libro.titulo}", Toast.LENGTH_SHORT).show()
            }
        )

        binding.rvAdminLibros.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
