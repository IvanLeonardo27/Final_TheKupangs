package com.ubayadev.final_thekupangs_anmpc.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ubayadev.final_thekupangs_anmpc.data.HabitRepository
import com.ubayadev.final_thekupangs_anmpc.model.Habit
import com.ubayadev.final_thekupangs_anmpc.model.HabitDatabase
import kotlinx.coroutines.launch

class HabitViewModel(context: Context) : ViewModel() {

    private val repository: HabitRepository

    val todoLD= MutableLiveData<Habit>()
    val habits: LiveData<List<Habit>>

    init {
        val habitDao = HabitDatabase.getDatabase(context).habitDao()
        repository = HabitRepository(habitDao)
        habits = repository.getAllHabits()
    }

    fun addHabit(habit: Habit) {
        viewModelScope.launch {
            repository.addHabit(habit)
        }
    }

    fun getHabitById(id: Int) {
        viewModelScope.launch {
            todoLD.postValue(repository.getHabitById(id))

        }
    }

    fun updateProgress(id: Int, value: Int) {
        viewModelScope.launch {
            repository.updateProgress(id, value)
        }
    }

    fun updateHabit(habit: Habit) {
        viewModelScope.launch {
            repository.updateHabit(habit)
        }
    }
    }
