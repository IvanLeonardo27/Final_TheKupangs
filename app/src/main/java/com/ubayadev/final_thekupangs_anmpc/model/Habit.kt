package com.ubayadev.final_thekupangs_anmpc.model
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "habit_table")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val goal: Int,
    val progress: Int,
    val unit: String,
    val icon: Int,
    val status: String
)