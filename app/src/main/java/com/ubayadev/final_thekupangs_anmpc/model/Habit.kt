package com.ubayadev.final_thekupangs_anmpc.model
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "habit_table")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String,
    var description: String,
    var goal: Int,
    var progress: Int,
    var unit: String,
    var icon: Int,
    var status: String
)