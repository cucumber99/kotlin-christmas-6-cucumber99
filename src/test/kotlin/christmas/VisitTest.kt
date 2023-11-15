package christmas

import christmas.model.Visit
import christmas.util.Constants.FRIDAY
import christmas.util.Constants.MONDAY
import christmas.util.Constants.TUESDAY
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class VisitTest {
    @ParameterizedTest
    @CsvSource("1, $FRIDAY", "12, $TUESDAY", "25, $MONDAY")
    fun `요일 변환 계산 테스트`(date: Int, expected: Int) {
        val visit = Visit(date)
        assertEquals(expected, visit.day)
    }
}