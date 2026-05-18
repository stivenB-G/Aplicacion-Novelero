package com.example.appnovelero.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.appnovelero.databinding.FragmentDetalleLibroBinding

class BookDetailFragment : Fragment() {

    private var _binding: FragmentDetalleLibroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
     ): View {
        _binding = FragmentDetalleLibroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Recibimos los datos del Bundle
        arguments?.let { bundle ->
            val titulo = bundle.getString("titulo") ?: "Sin título"
            val autor = bundle.getString("autor") ?: "Anónimo"
            val precio = bundle.getDouble("precio", 0.0)
            val sinopsis = bundle.getString("sinopsis") ?: ""
            val rating = bundle.getDouble("rating", 0.0)
            val vistas = bundle.getInt("vistas", 0)
            val capitulos = bundle.getInt("capitulos", 0)
            val genero = bundle.getString("genero") ?: "Fantasía"

            // Inyectamos los datos en la interfaz
            binding.tvTituloDetalle.text = titulo
            binding.tvAutorDetalle.text = autor
            binding.tvSinopsisDetalle.text = sinopsis
            binding.tvRatingDetalle.text = rating.toString()
            binding.tvCapsDetalle.text = capitulos.toString()
            binding.tvVistasDetalle.text = formatVistas(vistas)
            binding.tvTagGenero.text = genero.uppercase()

            // Botón de precio dinámico
            if (precio > 0) {
                binding.tvBtnPrecioDetalle.text = "Comprar por $${precio.toInt()}"
            } else {
                binding.tvBtnPrecioDetalle.text = "Leer Gratis"
            }
        }

        binding.btnAgregarCarrito.setOnClickListener {
            Toast.makeText(context, "Agregado al carrito", Toast.LENGTH_SHORT).show()
        }
    }

    // Función para que las vistas se vean como "1.2M" o "12k"
    private fun formatVistas(vistas: Int): String {
        return when {
            vistas >= 1000000 -> "${vistas / 1000000}M"
            vistas >= 1000 -> "${vistas / 1000}k"
            else -> vistas.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
