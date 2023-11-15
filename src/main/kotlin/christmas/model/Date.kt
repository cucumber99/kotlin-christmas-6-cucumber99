package christmas.model

import christmas.util.Validator.validateDate

class Date (private val _date: Int){
    val date: Int
        get() = _date

    init {
        validateDate(_date)
    }
}