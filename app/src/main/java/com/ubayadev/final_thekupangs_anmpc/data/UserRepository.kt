package com.ubayadev.final_thekupangs_anmpc.data

import com.ubayadev.final_thekupangs_anmpc.model.User
import com.ubayadev.final_thekupangs_anmpc.model.UserDao

class UserRepository(private val userDao: UserDao) {

    suspend fun getUserCount(): Int = userDao.getUserCount()

    suspend fun insertUser(user: User) = userDao.insertUser(user)

    suspend fun getUser(username: String, password: String): User? =
        userDao.login(username, password)
}