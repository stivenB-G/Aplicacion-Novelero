package com.example.appnovelero.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.appnovelero.R
import com.example.appnovelero.adapter.LibroContinuacionAdapter
import com.example.appnovelero.adapter.LibroExplorarAdapter
import com.example.appnovelero.adapter.LibroHorizontalAdapter
import com.example.appnovelero.data.repository.BookRepository
import com.example.appnovelero.databinding.FragmentExplorarBinding
import com.example.appnovelero.dominio.model.Book
import kotlinx.coroutines.launch

class ExploreFragment : Fragment() {

    private var _binding: FragmentExplorarBinding? = null
    private val binding get() = _binding!!
    
    private val bookRepository = BookRepository()
    private var todasLasNovelas: List<Book> = emptyList()

    private lateinit var verticalAdapter: LibroExplorarAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExplorarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cargarDatosDesdeSupabase()
        setupListeners()
    }

    private fun cargarDatosDesdeSupabase() {
        lifecycleScope.launch {
            todasLasNovelas = bookRepository.getAllBooks()
            if (todasLasNovelas.isNotEmpty()) {
                setupCarousels()
                setupVerticalList()
            }
        }
    }

    private fun irADetalle(libro: Book) {
        val args = Bundle().apply {
            putString("titulo", libro.titulo)
            putString("autor", "Autor Novelero")
            putDouble("precio", libro.precio)
            putString("sinopsis", libro.sinopsis)
            putDouble("rating", libro.rating)
            putInt("vistas", libro.vistas)
            putInt("capitulos", libro.capitulos)
            putString("genero", libro.genero)
        }
        findNavController().navigate(R.id.action_navigation_explorar_to_navigation_detalle_libro, args)
    }

    private fun setupCarousels() {
        binding.rvRecomendadosHorizontal.apply {
            adapter = LibroHorizontalAdapter(todasLasNovelas.shuffled()) { irADetalle(it) }
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.rvRecientesHorizontal.apply {
            adapter = LibroHorizontalAdapter(todasLasNovelas.reversed()) { irADetalle(it) }
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.rvContinuacionHorizontal.apply {
            adapter = LibroContinuacionAdapter(todasLasNovelas) { irADetalle(it) }
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            onFlingListener = null
            LinearSnapHelper().attachToRecyclerView(this)
        }
    }

    private fun setupVerticalList() {
        verticalAdapter = LibroExplorarAdapter(todasLasNovelas.take(3)) { irADetalle(it) }
        binding.rvLibrosExplorar.apply {
            adapter = verticalAdapter
            layoutManager = LinearLayoutManager(context)
            isNestedScrollingEnabled = false
        }
    }

    private fun setupListeners() {
        binding.btnVerMasPopulares.setOnClickListener {
            verticalAdapter.updateList(todasLasNovelas)
            binding.btnVerMasPopulares.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
