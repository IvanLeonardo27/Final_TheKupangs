package com.ubayadev.habbit_thekupangs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ubayadev.final_thekupangs_anmpc.viewmodel.LoginViewModel
import com.ubayadev.habbit_thekupangs.R
import com.ubayadev.habbit_thekupangs.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel = LoginViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (viewModel.login(username, password)) {
                findNavController().navigate(R.id.action_dashboard)
            } else {
                Toast.makeText(requireContext(), "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}