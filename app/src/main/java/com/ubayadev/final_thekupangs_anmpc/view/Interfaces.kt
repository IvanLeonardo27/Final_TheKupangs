package com.ubayadev.final_thekupangs_anmpc.view

import android.view.View

interface HabitListListener{
    fun onclick(v: View)
    fun onclickPlusButton(v: View)
    fun onclickMinusButton(v: View)
}

interface EditHabitListener{
    fun onclick(v: View)
}