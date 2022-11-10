package com.blueland.mooddiary

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalendarCalculatorTest {

    private lateinit var calculator: CalendarCalculator

    @Before
    fun setUp() {
        calculator = CalendarCalculator()
    }

    @Test
    fun getFirstWeekdayOfMonth() {
        assertEquals(calculator.getFirstWeekdayOfMonth("2022-10-06"), 7)
        assertEquals(calculator.getFirstWeekdayOfMonth("2022-11-06"), 3)
        assertEquals(calculator.getFirstWeekdayOfMonth("2022-11-30"), 3)
        assertEquals(calculator.getFirstWeekdayOfMonth("2023-01-03"), 1)
    }
}