package com.example.appnovelero.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appnovelero.R

class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)

        view.findViewById<Button>(R.id.btn_finalizar_pago).setOnClickListener {
            Toast.makeText(context, "¡Pago realizado con éxito!", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack(R.id.navigation_biblioteca, false)
        }

        return view
    }
}
