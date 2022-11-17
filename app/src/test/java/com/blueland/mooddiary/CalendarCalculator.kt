package com.blueland.mooddiary

import java.text.SimpleDateFormat
import java.util.*

class CalendarCalculator {

    /** 입력한 날짜의 달의 시작 요일 반환
     *
     * @param date yyyy-MM-dd 형태의 날짜
     * @return 시작 요일
     */
    fun getFirstWeekdayOfMonth(date: String): Int {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = simpleDateFormat.parse(date)
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    /** 입력한 날짜의 달의 총 일수를 반환
     *
     * @param date yyyy-MM-dd 형태의 날짜
     * @return 총 일수
     */
    fun getDaysCountOfMonth(date: String): Int {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = simpleDateFormat.parse(date)
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    /** GridView 에 그릴 시작 요일의 index 반환
     *
     * @param isStartSun 일요일 시작 여부
     * @param firstWeekday 시작 요일
     * @return GridView index
     */
    fun getFirstIndexForDrawing(isStartSun: Boolean, firstWeekday: Int): Int {
        return if (isStartSun) firstWeekday - 1 else if (firstWeekday == 1) 6 else firstWeekday - 2
    }

    /** GridView 에 그릴 입력한 날짜의 index 반환
     *
     * @param isStartSun 일요일 시작 여부
     * @param date yyyy-MM-dd 형태의 날짜
     * @return GridView index
     */
    fun getIndexForDrawing(isStartSun: Boolean, date: String): Int {
        val firstWeekday = getFirstWeekdayOfMonth(date)
        return getFirstIndexForDrawing(isStartSun, firstWeekday) + date.substring(8, 10).toInt() - 1
    }
}