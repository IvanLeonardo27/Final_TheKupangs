package com.ubayadev.final_thekupangs_anmpc.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.room.InvalidationTracker
import com.ubayadev.final_thekupangs_anmpc.util.HabitIcons
import com.ubayadev.final_thekupangs_anmpc.viewmodel.HabitViewModel
import com.ubayadev.habbit_thekupangs.R
import com.ubayadev.habbit_thekupangs.databinding.FragmentEditHabitBinding
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.ubayadev.final_thekupangs_anmpc.model.Habit


class EditHabitFragment : Fragment(), EditHabitListener {
    private lateinit var viewModel: HabitViewModel
    private lateinit var binding: FragmentEditHabitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditHabitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = HabitViewModel(requireContext().applicationContext)
        binding.listener = this
        binding.txtJudul.text ="Edit Habit"
        val uuid = EditHabitFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.getHabitById(uuid)
        observeViewModel()

        val iconLabels = HabitIcons.options.map { it.label }
        val spinnerAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            iconLabels
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerIcon.adapter = spinnerAdapter
    }

    fun observeViewModel(){
        viewModel.todoLD.observe(viewLifecycleOwner, Observer{
            binding.habit=it
            binding.listener = this
        })
    }

    override fun onclick(v: View) {
        val obj =binding.habit as Habit
        viewModel.updateHabit(obj)
        Toast.makeText(v.context, "Todo Updated", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(v).popBackStack()

    }

}