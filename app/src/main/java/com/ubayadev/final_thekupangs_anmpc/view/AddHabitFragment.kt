package com.ubayadev.final_thekupangs_anmpc.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ubayadev.final_thekupangs_anmpc.model.Habit
import com.ubayadev.final_thekupangs_anmpc.util.HabitIcons
import com.ubayadev.habbit_thekupangs.R
import com.ubayadev.habbit_thekupangs.databinding.FragmentAddHabitBinding
import com.ubayadev.final_thekupangs_anmpc.viewmodel.HabitViewModel

class AddHabitFragment : Fragment() {

    private lateinit var binding: FragmentAddHabitBinding
    private lateinit var viewModel: HabitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_habit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddHabitBinding.bind(view)
        viewModel = HabitViewModel(requireContext().applicationContext)

        val iconLabels = HabitIcons.options.map { it.label }
        val spinnerAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            iconLabels
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerIcon.adapter = spinnerAdapter

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val desc = binding.etDesc.text.toString()
            val goalText = binding.etGoal.text.toString()
            val unit = binding.etUnit.text.toString()

            if (name.isBlank() || goalText.isBlank() || unit.isBlank()) {
                Toast.makeText(requireContext(), "Semua field wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedIcon = binding.spinnerIcon.selectedItemPosition

            val habit = Habit(
                name = name,
                description = desc,
                goal = goalText.toInt(),
                progress = 0,
                unit = unit,
                icon = selectedIcon,
                status = "In Progress"
            )

            viewModel.addHabit(habit)
            findNavController().popBackStack()
        }
    }
}