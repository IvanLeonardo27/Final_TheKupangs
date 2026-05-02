package com.ubayadev.habbit_thekupangs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.ubayadev.final_thekupangs_anmpc.model.Habit
import com.ubayadev.habbit_thekupangs.R
import com.ubayadev.habbit_thekupangs.databinding.FragmentAddHabitBinding
import com.ubayadev.habbit_thekupangs.viewmodel.HabitViewModel
import kotlin.random.Random

class AddHabitFragment : Fragment() {

    private lateinit var binding: FragmentAddHabitBindin
    private val viewModel = HabitViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddHabitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val iconMap = mapOf(
            "Reading" to R.drawable.baseline_library_books_24,
            "Drinking Water" to R.drawable.baseline_water_drop_24,
            "Exercise" to R.drawable.baseline_sports_gymnastics_24
        )

        val iconNames = iconMap.keys.toList()

        val spinnerAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            iconNames
        )

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerIcon.adapter = spinnerAdapter

        var selectedIcon = iconMap.values.first()

        binding.spinnerIcon.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedIcon = iconMap.values.elementAt(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.btnSave.setOnClickListener {

            val habit = Habit(
                id = Random.nextInt(),
                name = binding.etName.text.toString(),
                description = binding.etDesc.text.toString(),
                goal = binding.etGoal.text.toString().toInt(),
                progress = 0,
                unit = binding.etUnit.text.toString(),
                icon = 0,
                status = "In Progress"
            )

            viewModel.addHabit(habit)

            val action = AddHabitFragmentDirections.actionDashboardFragment()
            findNavController().popBackStack()
        }
    }
}