package christmas

import christmas.model.Badge
import christmas.util.Constants.SANTA_BADGE
import christmas.util.Constants.SANTA_BOUNDARY
import christmas.util.Constants.STAR_BADGE
import christmas.util.Constants.STAR_BOUNDARY
import christmas.util.Constants.TREE_BADGE
import christmas.util.Constants.TREE_BOUNDARY
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BadgeTest {
    @ParameterizedTest
    @ValueSource(ints = [25000, 12000, 8000, 1000])
    fun `discount 값에 따른 badge 값 테스트`(discount: Int) {
        val badge = Badge(discount)
        val expectedBadge = when {
            discount >= SANTA_BOUNDARY -> SANTA_BADGE
            discount >= TREE_BOUNDARY -> TREE_BADGE
            discount >= STAR_BOUNDARY -> STAR_BADGE
            else -> ""
        }
        assertEquals(expectedBadge, badge.badge)
    }
}