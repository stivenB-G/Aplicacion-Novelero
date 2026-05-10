package com.example.appnovelero.ui.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appnovelero.R

class LibraryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_biblioteca, container, false)

        val btnCart = view.findViewById<CardView>(R.id.btn_cart)
        btnCart.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_biblioteca_to_navigation_carrito)
        }

        return view
    }
}
