package christmas

import christmas.model.Discount
import christmas.model.Menu
import christmas.model.Visit
import christmas.util.Constants.CHRISTMAS
import christmas.util.Constants.SATURDAY
import christmas.util.Constants.TUESDAY
import christmas.util.Constants.WEDNESDAY
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DiscountTest {
    private val menuList = mapOf(Menu.CAKE.menuName to 5, Menu.SEAFOOD.menuName to 2, Menu.STEAK.menuName to 3)

    @ParameterizedTest
    @CsvSource (
        "12, 2100",
        "17, 2600",
        "25, 3400",
        "30, 0"
    )
    fun `디데이 할인 계산 테스트` (date: Int, expected: Int) {
        val visit = Visit(date)
        val discount = Discount(menuList, visit)
        assertEquals(expected, discount.daily)
    }

    @ParameterizedTest
    @CsvSource(
        "12, 10115",
        "17, 10115",
        "30, 0"
    )
    fun `평일 할인 계산 테스트` (date: Int, expected: Int) {
        val visit = Visit(date)
        val discount = Discount(menuList, visit)
        assertEquals(expected, discount.weekly)
    }

    @ParameterizedTest
    @CsvSource(
        "12, 0",
        "17, 0",
        "30, 10115"
    )
    fun `주말 할인 계산 테스트` (date: Int, expected: Int) {
        val visit = Visit(date)
        val discount = Discount(menuList, visit)
        assertEquals(expected, discount.weekend)
    }

    @ParameterizedTest
    @CsvSource(
        "12, 0",
        "17, 1000",
        "25, 1000"
    )
    fun `특별 할인 계산 테스트` (date: Int, expected: Int) {
        val visit = Visit(date)
        val discount = Discount(menuList, visit)
        assertEquals(expected, discount.special)
    }

    @ParameterizedTest
    @CsvSource(
        "12, 12215",
        "17, 13715",
        "25, 14515"
    )
    fun `할인 총액 계산 테스트` (date: Int, expected: Int) {
        val visit = Visit(date)
        val discount = Discount(menuList, visit)
        assertEquals(expected, discount.discount)
    }
}