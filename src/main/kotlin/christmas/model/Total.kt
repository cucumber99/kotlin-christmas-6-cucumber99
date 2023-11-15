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
        _presentation = getPresentation()
        _totalDiscount = discount + _presentation
        _payment = getPayment() - _totalDiscount
    }

    private fun getPayment(): Int {
        return price - discount
    }

    private fun getPresentation(): Int {
        if(price >= PRESENTATION_AMOUNT) {
            return Menu.CHAMPAGNE.price
        }
        return 0
    }
}