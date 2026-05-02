package com.ubayadev.habbit_thekupangs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubayadev.habbit_thekupangs.databinding.FragmentDashboardBinding
import com.ubayadev.habbit_thekupangs.viewmodel.HabitViewModel
import androidx.lifecycle.Observer

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    private val habitListAdapter = HabitListAdapter(arrayListOf())
    private lateinit var viewModel:HabitViewModel

//    private val viewModel = HabitViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(inflater,container,false)
        return binding.root
//
//        viewModel.loadHabits()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(HabitViewModel::class.java)
        viewModel.loadHabits()

        binding.rvHabit.layoutManager = LinearLayoutManager(context)
        binding.rvHabit.adapter = habitListAdapter


        binding = FragmentDashboardBinding.bind(view)

        observeViewModel()

        val action = DashboardFragmentDirections.actionAddHabit()
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(action)
        }
    }

    fun observeViewModel(){
        viewModel.habits.observe(viewLifecycleOwner, Observer{
            habitListAdapter.updateHabitList(it)
        })
    }
}