package christmas

import christmas.model.MenuList
import christmas.model.Price
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PriceTest {
    @ParameterizedTest
    @CsvSource(
        "'티본스테이크-1,해산물파스타-1', 90000",
        "'수프-2,레드와인-1', 72000"
    )
    fun `총 주문 금액 계산 테스트`(
        input: String,
        expected: Int
    ) {
        val menuList = MenuList(input)
        val price = Price(menuList.menus)
        assertEquals(expected, price.price)
    }
}