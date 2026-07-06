//package com.ubayadev.habbit_thekupangs.view
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.ubayadev.final_thekupangs_anmpc.model.Habit
//import com.ubayadev.habbit_thekupangs.databinding.ItemHabitBinding
//
//class HabitListAdapter(val habitList: ArrayList<Habit>):
//    RecyclerView.Adapter<HabitListAdapter.HabitViewHolder>() {
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): HabitViewHolder {
//        val binding= ItemHabitBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return HabitViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(
//        holder: HabitViewHolder,
//        position: Int
//    ) {
//
//        holder.binding.progressBar.max = habitList[position].goal
//
//        holder.binding.progressBar.progress = habitList[position].progress
//
//        if(habitList[position].progress< habitList[position].goal) {
//            holder.binding.btnPlus.setOnClickListener {
//                habitList[position].progress += 1
//                notifyDataSetChanged()
//            }
//
//            holder.binding.btnMinus.setOnClickListener {
//                if(habitList[position].progress > 0){
//                    habitList[position].progress -= 1
//                    notifyDataSetChanged()
//                }
//
//            }
//        }
//
//        else{
//            habitList[position].status = "Completed"
//            holder.binding.btnPlus.isEnabled = false
//            holder.binding.btnMinus.isEnabled = false
//        }
//
//        holder.binding.ivHabitIcon.setImageResource(habitList[position].icon)
//        holder.binding.tvHabitTitle.text =habitList[position].name
//        holder.binding.tvHabitDescription.text = habitList[position].description
//        holder.binding.tvStatus.text = habitList[position].status
//        holder.binding.tvProgress.text = habitList[position].progress.toString()
//        holder.binding.tvGoal.text = habitList[position].goal.toString()
//        holder.binding.tvUnit.text = habitList[position].unit
//    }
//
//    override fun getItemCount(): Int {
//        return habitList.size
//    }
//
//    fun updateHabitList(newHabitList: ArrayList<Habit>){
//        habitList.clear()
//        habitList.addAll(newHabitList)
//        notifyDataSetChanged()
//    }
//
//
//    class HabitViewHolder(var binding : ItemHabitBinding)
//        : RecyclerView.ViewHolder(binding.root)
//}