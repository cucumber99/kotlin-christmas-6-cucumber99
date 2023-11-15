package christmas.model

import christmas.util.Constants.ZERO

class Price(private val menuList: Map<String, Int>) {
    private var _price: Int

    val price: Int
        get() = _price

    init {
        _price = calculatePrice()
    }

    fun calculatePrice(): Int {
        var totalPrice = ZERO
        menuList.forEach { (menuName, quantity) ->
            val menu = Menu.entries.first { it.menuName == menuName }
            totalPrice += menu.price * quantity
        }
        return totalPrice
    }
}