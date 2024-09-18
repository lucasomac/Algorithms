package br.com.lucolimac

object DateExtensions {
    // Define a function that receives a date and returns a date added a quantity of days
    fun addDays(date: java.util.Date, days: Int): java.util.Date {
        val calendar = java.util.Calendar.getInstance()
        calendar.time = date
        calendar.add(java.util.Calendar.DATE, days)
        return calendar.time
    }

    // Define a function that given a date then return day of week in portuguese
    fun getDayOfWeek(date: java.util.Date): String {
        val daysOfWeek = arrayOf("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado")
        val calendar = java.util.Calendar.getInstance()
        calendar.time = date
        val dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK)
        return daysOfWeek[dayOfWeek - 1]
    }
}