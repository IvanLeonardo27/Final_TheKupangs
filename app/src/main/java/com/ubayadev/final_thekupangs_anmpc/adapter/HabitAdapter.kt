package com.ubayadev.final_thekupangs_anmpc.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubayadev.final_thekupangs_anmpc.model.Habit
import com.ubayadev.final_thekupangs_anmpc.util.HabitIcons
import com.ubayadev.habbit_thekupangs.databinding.ItemHabitBinding
import com.ubayadev.final_thekupangs_anmpc.viewmodel.HabitViewModel
class HabitAdapter(
    private var habitList: List<Habit>,
    private val viewModel: HabitViewModel
) : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {
    fun submitList(newList: List<Habit>) {
        habitList = newList
        notifyDataSetChanged()
    }
    inner class HabitViewHolder(val binding: ItemHabitBinding)
        : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): HabitViewHolder {
        val binding = ItemHabitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HabitViewHolder(binding)
    }
    override fun onBindViewHolder(holder: HabitViewHolder, position:
    Int) {
        val habit = habitList[position]
        with(holder.binding) {
            tvHabitTitle.text = habit.name
            tvHabitDescription.text = habit.description
            tvStatus.text = habit.status
            tvHabitIcon.text = HabitIcons.emojiFor(habit.icon)
            progressBar.max = habit.goal
            progressBar.progress = habit.progress
            tvProgress.text = habit.progress.toString()
            tvGoal.text = habit.goal.toString()
            tvUnit.text = habit.unit
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
