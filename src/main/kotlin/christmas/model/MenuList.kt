package christmas.model

import christmas.util.Constants.COUNT_SEPARATOR
import christmas.util.Constants.MENU_SEPARATOR
import christmas.util.Validator.validateBeverage
import christmas.util.Validator.validateCounts
import christmas.util.Validator.validateDuplicate
import christmas.util.Validator.validateMenuNames
import christmas.util.Validator.validateTotalCount

class MenuList(input: String) {
    private val _menus: Map<String, Int>

    val menus: Map<String, Int>
        get() = _menus

    init {
        val convertedMap = convert(input)
        validateCounts(convertedMap.values)
        validateTotalCount(convertedMap.values)
        validateMenuNames(convertedMap)
        validateDuplicate(input, convertedMap)
        validateBeverage(convertedMap)
        _menus = convertedMap
    }

    private fun convert(input: String): Map<String, Int> {
        return input.split(MENU_SEPARATOR).associate { item ->
            val (name, count) = item.split(COUNT_SEPARATOR)
            name to count.toInt()
        }
    }
}