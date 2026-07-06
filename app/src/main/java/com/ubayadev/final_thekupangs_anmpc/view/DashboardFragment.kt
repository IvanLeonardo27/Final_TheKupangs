package com.ubayadev.final_thekupangs_anmpc.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubayadev.final_thekupangs_anmpc.adapter.HabitAdapter
import com.ubayadev.final_thekupangs_anmpc.viewmodel.HabitViewModel
import com.ubayadev.habbit_thekupangs.R
import com.ubayadev.habbit_thekupangs.databinding.FragmentDashboardBinding
class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var viewModel: HabitViewModel
    private lateinit var adapter: HabitAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard,
            container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState:
    Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDashboardBinding.bind(view)
        viewModel =
            HabitViewModel(requireContext().applicationContext)

        adapter = HabitAdapter(emptyList(), viewModel)
        binding.rvHabit.layoutManager =
            LinearLayoutManager(requireContext())
        binding.rvHabit.adapter = adapter
        viewModel.habits.observe(viewLifecycleOwner) { habitList ->
            adapter.submitList(habitList)
        }
        binding.fabAdd.setOnClickListener {

            findNavController().navigate(R.id.action_addHabit)
        }
    }
}