package christmas

import christmas.util.Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest {
    @Test
    fun `입력된 날짜의 값이 존재하지 않는 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateDateNull("")
        }
    }

    @Test
    fun `입력된 메뉴의 값이 존재하지 않는 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateMenuNull("")
        }
    }

    @Test
    fun `입력된 날짜가 유효하지 않는 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateDate(32)
        }
    }

    @Test
    fun `입력된 메뉴가 일치하지 않는 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateMenuNames(mapOf("라면" to 3))
        }
    }

    @Test
    fun `입력된 메뉴가 중복되는 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateDuplicate("해산물파스타-1,해산물파스타-2", mapOf("해산물파스타" to 3))
        }
    }

    @Test
    fun `입력된 메뉴 개수의 총합이 20을 초과한 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateTotalCount(listOf(10, 11))
        }
    }

    @Test
    fun `입력된 메뉴가 음료수만 존재하는 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateBeverage(mapOf("제로콜라" to 1))
        }
    }

    @Test
    fun `입력된 메뉴에 공백이 존재하는 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateNoBlank("해산물파스타- 1, 레드와인 -1")
        }
    }

    @Test
    fun `메뉴와 개수 사이의 구분자가 없는 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateMenuSeparator("해산물파스타1,레드와인1")
        }
    }

    @Test
    fun `메뉴와 개수 사이의 구분자가 올바르지 않은 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateCountSeparator("해산물파스타:1,레드와인:1")
        }
    }
}