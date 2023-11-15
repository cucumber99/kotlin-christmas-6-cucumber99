package christmas.view

import christmas.model.*
import christmas.util.Constants.BADGE_MESSAGE
import christmas.util.Constants.DAILY_MESSAGE
import christmas.util.Constants.EVENT_MESSAGE
import christmas.util.Constants.MENU_MESSAGE
import christmas.util.Constants.NONE_MESSAGE
import christmas.util.Constants.NUMBER_FORMAT
import christmas.util.Constants.ORDER_MESSAGE
import christmas.util.Constants.PAYMENT_MESSAGE
import christmas.util.Constants.PRESENTATION_MENU_MESSAGE
import christmas.util.Constants.PRESENTATION_MESSAGE
import christmas.util.Constants.PRICE_MESSAGE
import christmas.util.Constants.SPECIAL_MESSAGE
import christmas.util.Constants.START_MESSAGE
import christmas.util.Constants.TOTAL_DISCOUNT_MESSAGE
import christmas.util.Constants.WEEKEND_MESSAGE
import christmas.util.Constants.WEEKLY_MESSAGE
import christmas.util.Constants.ZERO

class OutputView {
    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printChoiceMessage() {
        println(ORDER_MESSAGE)
    }

    fun printEventMessage(visit: Visit) {
        println(String.format(EVENT_MESSAGE, visit.date))
    }

    fun printOrder(menu: MenuList) {
        val menuList = menu.menus
        println(MENU_MESSAGE)
        menuList.forEach { (name, count) ->
            println("$name: ${count}개")
        }
        println()
    }

    fun printPrice(price: Price) {
        val formattedPrice = String.format(NUMBER_FORMAT, price.price)
        println(String.format(PRICE_MESSAGE, formattedPrice))
    }

    fun printPresentation(total: Total) {
        if (total.presentation != ZERO) {
            println(PRESENTATION_MENU_MESSAGE)
            return
        }
        println(NONE_MESSAGE)
    }

    private fun printDiscount(discount: Int, message: String) {
        if (discount != ZERO) {
            val formattedDiscount = String.format(NUMBER_FORMAT, discount)
            println(String.format(message, formattedDiscount))
        }
    }

    fun printDiscountList(total: Total, discount: Discount) {
        if(total.totalDiscount != ZERO) {
            printDiscount(discount.daily, DAILY_MESSAGE)
            printDiscount(discount.weekly, WEEKLY_MESSAGE)
            printDiscount(discount.weekend, WEEKEND_MESSAGE)
            printDiscount(discount.special, SPECIAL_MESSAGE)
            printDiscount(total.presentation, PRESENTATION_MESSAGE)
            return
        }
        println(NONE_MESSAGE)
    }

    fun printTotalDiscount(total: Total) {
        val formattedDiscount = String.format(NUMBER_FORMAT, total.totalDiscount)
        println(String.format(TOTAL_DISCOUNT_MESSAGE, formattedDiscount))
    }

    fun printPayment(total: Total) {
        val formattedPayment = String.format(NUMBER_FORMAT, total.payment)
        println(String.format(PAYMENT_MESSAGE, formattedPayment))
    }

    fun printBadge(badge: Badge) {
        println(BADGE_MESSAGE)
        if(badge.badge.isNotEmpty()) {
            println(badge.badge)
            return
        }
        println(NONE_MESSAGE)
    }
}