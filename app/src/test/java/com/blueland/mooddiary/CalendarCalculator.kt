package com.blueland.mooddiary

import java.text.SimpleDateFormat
import java.util.*

class CalendarCalculator {

    fun getFirstWeekdayOfMonth(date: String): Int {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = simpleDateFormat.parse(date)
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        return calendar.get(Calendar.DAY_OF_WEEK)
    }
}