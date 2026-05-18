package com.example.appnovelero.ui.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnovelero.adapter.MetodoPagoAdapter
import com.example.appnovelero.databinding.FragmentPaymentBinding
import com.example.appnovelero.dominio.model.Payment

class PaymentFragment : Fragment() {

    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, 
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMetodosPago()

        binding.btnPay.setOnClickListener {
            Toast.makeText(context, "¡Suscripción Premium activada!", Toast.LENGTH_LONG).show()
            activity?.onBackPressedDispatcher?.onBackPressed()
        }

        binding.btnAnadirMetodoPremium.setOnClickListener {
            Toast.makeText(context, "Funcionalidad para añadir método de pago", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupMetodosPago() {
        val listaMetodos = listOf(
            Payment(id = "1", numero_enmascarado = "**** **** **** 4582", es_predeterminado = true)
        )

        val adapter = MetodoPagoAdapter(
            listaMetodos,
            onSelected = { metodo ->
                Toast.makeText(context, "Seleccionada: ${metodo.numero_enmascarado}", Toast.LENGTH_SHORT).show()
            }
        ) { metodo ->
            Toast.makeText(context, "Eliminando método: ${metodo.numero_enmascarado}", Toast.LENGTH_SHORT).show()
        }

        binding.rvMetodosPagoPremium.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
