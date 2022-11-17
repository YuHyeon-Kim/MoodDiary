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

    @Test
    fun getDaysCountOfMonth() {
        assertEquals(calculator.getDaysCountOfMonth("2022-10-06"), 31)
        assertEquals(calculator.getDaysCountOfMonth("2022-11-06"), 30)
        assertEquals(calculator.getDaysCountOfMonth("2022-11-30"), 30)
        assertEquals(calculator.getDaysCountOfMonth("2023-01-03"), 31)
    }

    @Test
    fun getFirstIndexForDrawing() {
        assertEquals(calculator.getFirstIndexForDrawing(true, 1), 0) // 시작 요일 - 일, 요일 - 일
        assertEquals(calculator.getFirstIndexForDrawing(true, 2), 1) // 시작 요일 - 일, 요일 - 월
        assertEquals(calculator.getFirstIndexForDrawing(true, 7), 6) // 시작 요일 - 일, 요일 - 토
        assertEquals(calculator.getFirstIndexForDrawing(false, 1), 6) // 시작 요일 - 월, 요일 - 일
        assertEquals(calculator.getFirstIndexForDrawing(false, 2), 0) // 시작 요일 - 월, 요일 - 월
        assertEquals(calculator.getFirstIndexForDrawing(false, 7), 5) // 시작 요일 - 월, 요일 - 토
    }

    @Test
    fun getIndexForDrawing() {
        assertEquals(calculator.getIndexForDrawing(true, "2022-11-01"), 2) // 시작 요일 - 일, 요일 - 화
        assertEquals(calculator.getIndexForDrawing(true, "2022-11-14"), 15) // 시작 요일 - 일, 요일 - 월
        assertEquals(calculator.getIndexForDrawing(false, "2022-11-01"), 1) // 시작 요일 - 월, 요일 - 화
        assertEquals(calculator.getIndexForDrawing(false, "2022-11-14"), 14) // 시작 요일 - 월, 요일 - 월
    }
}