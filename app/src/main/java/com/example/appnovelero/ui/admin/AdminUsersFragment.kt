package com.example.appnovelero.ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnovelero.adapter.UsuarioAdminAdapter
import com.example.appnovelero.databinding.FragmentAdminUsuariosBinding
import com.example.appnovelero.dominio.model.User

class AdminUsersFragment : Fragment() {

    private var _binding: FragmentAdminUsuariosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminUsuariosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLists()
        
        binding.btnAgregarUsuario.setOnClickListener {
            val dialog = AddUserDialogFragment.newInstance()
            dialog.show(childFragmentManager, AddUserDialogFragment.TAG)
        }
    }

    private fun setupLists() {
        val admins = listOf(
            User(nombre = "Admin Principal", rol = "Super Admin"),
            User(nombre = "Moderador", rol = "Admin 1"),
            User(nombre = "Moderador", rol = "Admin 2")
        )

        val usuarios = listOf(
            User(nombre = "Andres347", rol = "PREMIUM"),
            User(nombre = "Juan Duran", rol = "FREE"),
            User(nombre = "MelizzX", rol = "PREMIUM"),
            User(nombre = "@light_novel_fan", rol = "FREE"),
            User(nombre = "Carlos_Writer", rol = "PREMIUM")
        )

        binding.rvAdminLista.apply {
            adapter = UsuarioAdminAdapter(admins, 
                onEditClick = { Toast.makeText(context, "Editando Admin: ${it.nombre}", Toast.LENGTH_SHORT).show() },
                onDeleteClick = { Toast.makeText(context, "Eliminando Admin: ${it.nombre}", Toast.LENGTH_SHORT).show() }
            )
            layoutManager = LinearLayoutManager(context)
            isNestedScrollingEnabled = false
        }

        binding.rvUsuariosLista.apply {
            adapter = UsuarioAdminAdapter(usuarios,
                onEditClick = { Toast.makeText(context, "Editando Usuario: ${it.nombre}", Toast.LENGTH_SHORT).show() },
                onDeleteClick = { Toast.makeText(context, "Eliminando Usuario: ${it.nombre}", Toast.LENGTH_SHORT).show() }
            )
            layoutManager = LinearLayoutManager(context)
            isNestedScrollingEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
