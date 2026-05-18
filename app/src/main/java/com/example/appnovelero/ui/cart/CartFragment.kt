package com.example.appnovelero.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnovelero.R
import com.example.appnovelero.adapter.CarritoAdapter
import com.example.appnovelero.databinding.FragmentCarritoBinding
import com.example.appnovelero.dominio.model.Book
import com.example.appnovelero.dominio.model.CartItem

class CartFragment : Fragment() {

    private var _binding: FragmentCarritoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarritoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        
        binding.btnProcederPago.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_carrito_to_checkoutFragment)
        }
    }

    private fun setupRecyclerView() {
        // Datos de prueba para el carrito
        val itemsCarrito = listOf(
            CartItem(libro = Book(titulo = "La espada del guerrero", precio = 25000.0)),
            CartItem(libro = Book(titulo = "Hyber Cyber", precio = 32000.0)),
            CartItem(libro = Book(titulo = "Cielo de Ceniza", precio = 15000.0)),
            CartItem(libro = Book(titulo = "El Reino Perdido", precio = 28000.0)),
            CartItem(libro = Book(titulo = "Protocolo Cero", precio = 22000.0))
        )

        val adapter = CarritoAdapter(itemsCarrito, onRemoveClick = {
            Toast.makeText(context, "Eliminando: ${it.libro.titulo}", Toast.LENGTH_SHORT).show()
        })

        binding.rvCarrito.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }

        // Actualizamos los textos del resumen
        val total = itemsCarrito.sumOf { it.libro.precio }
        binding.tvItemsCount.text = getString(R.string.articulos_en_orden, itemsCarrito.size)
        binding.tvTotalValor.text = "$ ${total.toInt()} COP"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
