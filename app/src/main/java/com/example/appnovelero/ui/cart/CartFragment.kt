package com.example.appnovelero.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appnovelero.R

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_carrito, container, false)

        view.findViewById<Button>(R.id.btn_proceder_pago).setOnClickListener {
            findNavController().navigate(R.id.action_navigation_carrito_to_checkoutFragment)
        }

        return view
    }
}
