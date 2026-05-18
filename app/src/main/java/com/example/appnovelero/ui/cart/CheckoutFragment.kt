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
import com.example.appnovelero.adapter.MetodoPagoAdapter
import com.example.appnovelero.databinding.FragmentCheckoutBinding
import com.example.appnovelero.dominio.model.Payment

class CheckoutFragment : Fragment() {

    private var _binding: FragmentCheckoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMetodosPago()
        
        binding.btnFinalizarPago.setOnClickListener {
            Toast.makeText(context, "¡Pago realizado con éxito!", Toast.LENGTH_SHORT).show()
            // Regresamos a la biblioteca tras la compra exitosa
            findNavController().popBackStack(R.id.navigation_biblioteca, false)
        }

        binding.btnAnadirMetodo.setOnClickListener {
            Toast.makeText(context, "Funcionalidad para añadir nueva tarjeta", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupMetodosPago() {
        // Datos de prueba: Tarjetas guardadas
        val listaMetodos = listOf(
            Payment(id = "1", numero_enmascarado = "**** **** **** 4582", es_predeterminado = true),
            Payment(id = "2", numero_enmascarado = "**** **** **** 1029", es_predeterminado = false)
        )

        val adapter = MetodoPagoAdapter(
            listaMetodos,
            onSelected = { metodo ->
                Toast.makeText(context, "Seleccionada: ${metodo.numero_enmascarado}", Toast.LENGTH_SHORT).show()
            },
            onDelete = { metodo ->
                Toast.makeText(context, "Eliminando método: ${metodo.numero_enmascarado}", Toast.LENGTH_SHORT).show()
            }
        )

        binding.rvMetodosPago.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
