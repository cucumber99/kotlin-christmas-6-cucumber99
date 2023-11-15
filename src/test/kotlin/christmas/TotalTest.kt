package christmas

import christmas.model.Total
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TotalTest {
    @ParameterizedTest
    @CsvSource(
        "50000, 0, 0",
        "120000, 10000, 25000",
        "200000, 30000, 25000"
    )
    fun `증정 이벤트 테스트`(
        price: Int, discount: Int, expected: Int
    ){
        val total = Total(price, discount)
        assertEquals(expected, total.presentation)
    }

    @ParameterizedTest
    @CsvSource(
        "50000, 10000, 10000",
        "120000, 20000, 45000",
        "150000, 30000, 55000"
    )
    fun `총 혜택 금액 계산 테스트`(
        price: Int, discount: Int, expected: Int
    ) {
        val total = Total(price, discount)
        assertEquals(expected, total.totalDiscount)
    }

    @ParameterizedTest
    @CsvSource(
        "50000, 10000, 40000",
        "120000, 20000, 100000",
        "150000, 30000, 120000"
    )
    fun `예상 결제 금액 계산 테스트`(
        price: Int, discount: Int, expected: Int
    ) {
        val total = Total(price, discount)
        assertEquals(expected, total.payment)
    }
}
