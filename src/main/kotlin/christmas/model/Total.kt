package christmas.model

import christmas.util.Constants.PRESENTATION_AMOUNT

class Total(
    private val price: Int,
    private val discount: Int
) {
    private val _payment: Int
    private val _presentation: Int
    private val _totalDiscount: Int

    val payment: Int
        get() = _payment

    val presentation: Int
        get() = _presentation

    val totalDiscount: Int
        get() = _totalDiscount

    init {
        _presentation = calculatePresentation()
        _totalDiscount = discount + _presentation
        _payment = calculatePayment()
    }

    private fun calculatePayment(): Int {
        return price - discount
    }

    private fun calculatePresentation(): Int {
        if(price >= PRESENTATION_AMOUNT) {
            return Menu.CHAMPAGNE.price
        }
        return 0
    }
}