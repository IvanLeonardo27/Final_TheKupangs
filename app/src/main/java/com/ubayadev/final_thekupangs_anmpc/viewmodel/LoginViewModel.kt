package com.ubayadev.final_thekupangs_anmpc.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ubayadev.final_thekupangs_anmpc.data.UserRepository
import com.ubayadev.final_thekupangs_anmpc.model.HabitDatabase
import com.ubayadev.final_thekupangs_anmpc.model.User
import kotlinx.coroutines.launch

class LoginViewModel(context: Context) : ViewModel() {

    private val repository: UserRepository

    init {
        val userDao = HabitDatabase.getDatabase(context).userDao()
        repository = UserRepository(userDao)

        viewModelScope.launch {
            if (repository.getUserCount() == 0) {
                repository.insertUser(User(username = "student", password = "123"))
            }
        }
    }

    fun login(username: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = repository.getUser(username, password)
            onResult(user != null)
        }
    }
}