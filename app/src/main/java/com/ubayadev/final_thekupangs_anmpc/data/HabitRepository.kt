package com.ubayadev.habbit_thekupangs.data

import com.ubayadev.final_thekupangs_anmpc.model.Habit

object HabitRepository {

    private val habitList = mutableListOf<Habit>()

    fun getHabits(): ArrayList<Habit> = habitList as ArrayList<Habit>

    fun addHabit(habit: Habit) {
        habitList.add(habit)
    }

    fun updateProgress(id: Int, value: Int) {
        habitList.find { it.id == id }?.let {
            it.progress += value
            if (it.progress < 0) it.progress = 0
            if (it.progress > it.goal) it.progress = it.goal
        }
    }
}