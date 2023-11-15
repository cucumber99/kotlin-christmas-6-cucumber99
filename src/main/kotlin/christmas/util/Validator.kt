package christmas.util

import christmas.model.Menu
import christmas.util.Constants.COUNT_SEPARATOR
import christmas.util.Constants.MENU_SEPARATOR
import christmas.util.Constants.PARTS_SIZE

object Validator {
    fun validateNull(input: String) {
        require(input.trim().isNotEmpty()) {
            ErrorMessage.INPUT_NULL.getMessage()
        }
    }

    fun validateDate(input: Int) {
        require(input in 1..31) {
            ErrorMessage.DATE_RANGE.getMessage()
        }
    }

    fun validateInteger(input: String) {
        require(input.toIntOrNull() != null) {
            ErrorMessage.INPUT_NUMBER.getMessage()
        }
    }

    fun validateCounts(input: Collection<Int?>) {
        for (count in input) {
            require(count != null) {
                ErrorMessage.MENU_NUMBER.getMessage()
            }
        }
    }

    fun validateTotalCount(input: Collection<Int>) {
        for (count in input) {
            require(count <= 20) {
                ErrorMessage.MENU_COUNT.getMessage()
            }
        }
    }

    fun validateMenuNames(menus: Map<String, Int?>) {
        menus.keys.forEach { menuName ->
            require(Menu.entries.any { it.menuName == menuName }) {
                ErrorMessage.MENU_NAME.getMessage()
            }
        }
    }

    fun validateDuplicate(input: String, menus: Map<String, Int?>) {
        val menuCount = input.split(MENU_SEPARATOR).size
        require(menuCount == menus.size) {
            ErrorMessage.MENU_DUPLICATE.getMessage()
        }
    }

    fun validateBeverage(menus: Map<String, Int?>) {
        val drinks = setOf(Menu.COKE.menuName, Menu.WINE.menuName, Menu.CHAMPAGNE.menuName)
        require(menus.keys.any { it !in drinks }) {
            ErrorMessage.MENU_BEVERAGE.getMessage()
        }
    }

    fun validateMenuSeparator(input: String) {
        input.split(MENU_SEPARATOR).forEach { item ->
            require(item.contains(COUNT_SEPARATOR)) {
                ErrorMessage.MENU_FORMAT.getMessage()
            }
        }
    }

    fun validateCountSeparator(input: String) {
        input.split(MENU_SEPARATOR).forEach { item ->
            val parts = item.split(COUNT_SEPARATOR)
            require(parts.size == PARTS_SIZE) {
                ErrorMessage.MENU_FORMAT.getMessage()
            }
        }
    }
}