package com.ubayadev.habbit_thekupangs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubayadev.final_thekupangs_anmpc.model.Habit
import com.ubayadev.habbit_thekupangs.data.HabitRepository

class HabitViewModel : ViewModel() {

    private val _habits = MutableLiveData<List<Habit>>()
    val habits: LiveData<List<Habit>> = _habits

    fun loadHabits() {
        _habits.value = HabitRepository.getHabits()
    }

    fun addHabit(habit: Habit) {
        HabitRepository.addHabit(habit)
        loadHabits()
    }

    fun updateProgress(id: Int, value: Int) {
        HabitRepository.updateProgress(id, value)
        loadHabits()
    }
}