package com.ubayadev.final_thekupangs_anmpc.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface HabitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: Habit)

    @Update
    suspend fun updateHabit(habit: Habit)

    @Query("SELECT * FROM habit_table ORDER BY id ASC")
    fun getAllHabits(): LiveData<List<Habit>>

    @Query("SELECT * FROM habit_table WHERE id = :id LIMIT 1")
    suspend fun getHabitById(id: Int): Habit?
}