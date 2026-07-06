package com.ubayadev.final_thekupangs_anmpc.data

import androidx.lifecycle.LiveData
import com.ubayadev.final_thekupangs_anmpc.model.Habit
import com.ubayadev.final_thekupangs_anmpc.model.HabitDao

class HabitRepository(private val habitDao: HabitDao) {

    fun getAllHabits(): LiveData<List<Habit>> = habitDao.getAllHabits()

    suspend fun addHabit(habit: Habit) {
        habitDao.insertHabit(habit)
    }

    suspend fun updateProgress(id: Int, value: Int) {
        val habit = habitDao.getHabitById(id) ?: return

        var newProgress = habit.progress + value
        if (newProgress < 0) newProgress = 0
        if (newProgress > habit.goal) newProgress = habit.goal

        val newStatus = if (newProgress >= habit.goal) "Completed" else "In Progress"

        habitDao.updateHabit(habit.copy(progress = newProgress, status = newStatus))
    }
}