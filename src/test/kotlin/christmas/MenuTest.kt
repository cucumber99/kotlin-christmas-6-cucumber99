package christmas

import christmas.model.MenuList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MenuTest {
    @ParameterizedTest
    @CsvSource (
        "'초코케이크-5,아이스크림-3', '초코케이크', 5, '아이스크림', 3",
        "'티본스테이크-2,바비큐립-7,아이스크림-4', '티본스테이크', 2, '바비큐립', 7, '아이스크림', 4"
    )
    fun `Map 변환 테스트`(
        input: String,
        expectedName1: String, expectedCount1: Int,
        expectedName2: String, expectedCount2: Int
    ) {
        val menuList = MenuList(input)
        val menus = menuList.menus
        assertEquals(expectedCount1, menus[expectedName1])
        assertEquals(expectedCount2, menus[expectedName2])
    }
}