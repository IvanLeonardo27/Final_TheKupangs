package com.ubayadev.final_thekupangs_anmpc.util
object HabitIcons {
    data class IconOption(val label: String, val emoji: String)
    val options: List<IconOption> = listOf(
        IconOption("💧 Air Minum", "💧"),
        IconOption("🏃 Olahraga", "🏃"),
        IconOption("📖 Membaca", "📖"),
        IconOption("🧘 Meditasi", "🧘"),
        IconOption("😴 Tidur", "😴"),
        IconOption("📝 Lainnya", "📝")
    )
    fun emojiFor(index: Int): String =
        options.getOrElse(index) { options[0] }.emoji
}
