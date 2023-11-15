package christmas.controller

import christmas.model.*
import christmas.view.InputView
import christmas.view.OutputView

class Controller(private val inputView: InputView, private val outputView: OutputView) {
    private lateinit var badge: Badge
    private lateinit var discount: Discount
    private lateinit var menuList: MenuList
    private lateinit var price: Price
    private lateinit var total: Total
    private lateinit var visit: Visit

    fun start() {
        eventInit()
        calculate()
        showOrder()
        showDiscount()
        showResult()
    }

    private fun eventInit() {
        outputView.printStartMessage()
        getVisitDate()
        outputView.printChoiceMessage()
        getOrder()
        outputView.printEventMessage(visit)
    }

    private fun getVisitDate() {
        var isValidInput = false
        while(!isValidInput) {
            try {
                val input = inputView.getDate()
                visit = Visit(input)
                isValidInput = true
            } catch(e: IllegalArgumentException) {
                print(e.message)
            }
        }
    }

    private fun getOrder() {
        var isValidInput = false
        while(!isValidInput) {
            try {
                val input = inputView.getMenu()
                menuList = MenuList(input)
                isValidInput = true
            } catch(e: IllegalArgumentException) {
                print(e.message)
            }
        }
    }

    private fun calculate() {
        price = Price(menuList.menus)
        discount = Discount(menuList.menus, visit)
        total = Total(price.price, discount.discount)
        badge = Badge(total.totalDiscount)
    }

    private fun showOrder() {
        outputView.printOrder(menuList)
        outputView.printPrice(price)
        outputView.printPresentation(total)
    }

    private fun showDiscount() {
        outputView.printDiscountList(total, discount)
        outputView.printTotalDiscount(total)
    }

    private fun showResult() {
        outputView.printPayment(total)
        outputView.printBadge(badge)
    }
}