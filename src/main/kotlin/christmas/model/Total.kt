package christmas.model

import christmas.util.Constants.PRESENTATION_AMOUNT

class Total(
    private val price: Int,
    private val discount: Int
) {
    private val _payment: Int
    private val _presentation: Int

    val payment: Int
        get() = _payment

    val presentation: Int
        get() = _presentation

    init {
        _presentation = getPresentation()
        _payment = getPayment() + _presentation
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