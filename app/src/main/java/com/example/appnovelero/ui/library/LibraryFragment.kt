package com.example.appnovelero.ui.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appnovelero.R

class LibraryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Conectamos el fragmento con el diseño XML (fragment_library)
        return inflater.inflate(R.layout.fragment_biblioteca, container, false)
    }
}
