package christmas.model

import christmas.util.Constants.CHRISTMAS
import christmas.util.Constants.DAILY_DISCOUNT
import christmas.util.Constants.DAILY_DISCOUNT_ADD
import christmas.util.Constants.DISCOUNT_AMOUNT
import christmas.util.Constants.FIRST
import christmas.util.Constants.FRIDAY
import christmas.util.Constants.MONDAY
import christmas.util.Constants.SATURDAY
import christmas.util.Constants.SPECIAL_DISCOUNT
import christmas.util.Constants.SUNDAY
import christmas.util.Constants.THURSDAY
import christmas.util.Constants.TUESDAY
import christmas.util.Constants.WEDNESDAY
import christmas.util.Constants.ZERO

class Discount(
    private val menuList: Map<String, Int>,
    private val visit: Visit
) {
    companion object {
        private val DESSERT = setOf(Menu.CAKE.menuName, Menu.ICE.menuName)
        private val MAIN = setOf(Menu.STEAK.menuName, Menu.RIB.menuName, Menu.SEAFOOD.menuName, Menu.CHRISTMAS.menuName)
        private val WEEKLY = listOf(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY)
        private val WEEKEND = listOf(FRIDAY, SATURDAY)
    }

    private var _daily: Int
    private var _weekly: Int
    private var _weekend: Int
    private var _special: Int
    private var _discount: Int

    val discount: Int
        get() = _discount

    val daily: Int
        get() = _daily

    val weekly: Int
        get() = _weekly

    val weekend: Int
        get() = _weekend

    val special: Int
        get() = _special

    init {
        _daily = dailyDiscount()
        _weekly = weeklyDiscount()
        _weekend = weekendDiscount()
        _special = specialDiscount()
        _discount = calculateDiscount()
    }

    private fun dailyDiscount(): Int {
        return (visit.date in FIRST..CHRISTMAS).takeIf { it }?.let { DAILY_DISCOUNT + (visit.date-FIRST) * DAILY_DISCOUNT_ADD} ?: ZERO
    }

    private fun weeklyDiscount(): Int {
        if(visit.day in WEEKLY) {
            val dessertCount = menuList.filterKeys{ it in DESSERT }.values.sumOf { it.toInt() }
            return dessertCount * DISCOUNT_AMOUNT
        }
        return 0
    }

    private fun weekendDiscount(): Int {
        if(visit.day in WEEKEND) {
            val mainCount = menuList.filterKeys{ it in MAIN }.values.sumOf { it.toInt() }
            return mainCount * DISCOUNT_AMOUNT
        }
        return 0
    }

    private fun specialDiscount(): Int {
        if(visit.day == SUNDAY || visit.date == CHRISTMAS) {
            return SPECIAL_DISCOUNT
        }
        return 0
    }

    private fun calculateDiscount(): Int {
        return _daily + _weekly + _weekend + _special
    }
}