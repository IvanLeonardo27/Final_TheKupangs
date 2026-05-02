package com.ubayadev.habbit_thekupangs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ubayadev.final_thekupangs_anmpc.model.Habit
import com.ubayadev.habbit_thekupangs.R
import com.ubayadev.habbit_thekupangs.databinding.FragmentAddHabitBinding
import com.ubayadev.habbit_thekupangs.viewmodel.HabitViewModel
import kotlin.random.Random

class AddHabitFragment : Fragment() {

    private lateinit var binding: FragmentAddHabitBinding
    private val viewModel = HabitViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_habit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddHabitBinding.bind(view)

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

            findNavController().popBackStack()
        }
    }
}