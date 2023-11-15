package christmas.model

import christmas.util.Validator.validateDate

class Visit (private val _date: Int){
    private val _day: Int
    val date: Int
        get() = _date

    val day: Int
        get() = _day

    init {
        validateDate(_date)
        _day = convertDate()
    }

    private fun convertDate(): Int {
        return (_date + 4) % 7 + 1
    }
}