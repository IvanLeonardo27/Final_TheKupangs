package com.ubayadev.final_thekupangs_anmpc.view
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
import com.ubayadev.final_thekupangs_anmpc.util.SessionManager
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var sessionManager: SessionManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container,
            false)
    }
    override fun onViewCreated(view: View, savedInstanceState:
    Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sessionManager = SessionManager(requireContext())
        // Bonus poin: kalau sudah pernah login, langsung auto masuk Dashboard
        if (sessionManager.isLoggedIn()) {

            findNavController().navigate(R.id.action_dashboard)
            return
        }
        binding = FragmentLoginBinding.bind(view)
        viewModel =
            LoginViewModel(requireContext().applicationContext)
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            viewModel.login(username, password) { success ->
                if (success) {
                    sessionManager.saveSession(username)
                    findNavController().navigate(R.id.action_dashboard)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Username atau Password salah",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
