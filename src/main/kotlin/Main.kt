package br.com.lucolimac
import br.com.lucolimac.DateExtensions.addDays
import br.com.lucolimac.DateExtensions.getDayOfWeek
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // Operations with java.Util.Date
    val date = java.util.Date()
    println("Current date: $date")
    // Add 15 days to the current date
    val newDate = addDays(date, 15)
    println("New date: $newDate")

    // Get the day of the week in Portuguese
    val dayOfWeek = getDayOfWeek(newDate)
    println("Day of week: $dayOfWeek")
}