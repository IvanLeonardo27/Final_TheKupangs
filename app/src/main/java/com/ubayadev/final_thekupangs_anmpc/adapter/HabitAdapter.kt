package com.ubayadev.habbit_thekupangs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubayadev.final_thekupangs_anmpc.model.Habit
import com.ubayadev.habbit_thekupangs.databinding.ItemHabitBinding
import com.ubayadev.habbit_thekupangs.viewmodel.HabitViewModel

class HabitAdapter(
    private val habitList: List<Habit>,
    private val viewModel: HabitViewModel
) : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

    inner class HabitViewHolder(val binding: ItemHabitBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = ItemHabitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = habitList[position]

        with(holder.binding) {
            tvHabitTitle.text = habit.name
            tvHabitDescription.text = habit.description

            val status = if (habit.progress >= habit.goal) "Completed" else "In Progress"
            tvStatus.text = status

            progressBar.max = habit.goal
            progressBar.progress = habit.progress

            btnPlus.setOnClickListener {
                viewModel.updateProgress(habit.id, 1)
            }

            btnMinus.setOnClickListener {
                viewModel.updateProgress(habit.id, -1)
            }
        }
    }
    override fun getItemCount(): Int = habitList.size
}