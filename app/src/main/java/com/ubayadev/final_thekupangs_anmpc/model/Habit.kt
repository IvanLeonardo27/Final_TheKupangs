package com.ubayadev.final_thekupangs_anmpc.model

data class Habit(
    val id: Int,
    val name: String,
    val description: String,
    val goal: Int,
    var progress: Int,
    val unit: String,
    val icon: Int,
    var status : String
)
