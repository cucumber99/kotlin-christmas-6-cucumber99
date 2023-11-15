package christmas.util

import christmas.model.Menu
import christmas.util.Constants.COUNT_SEPARATOR
import christmas.util.Constants.MAX_COUNT
import christmas.util.Constants.MENU_SEPARATOR
import christmas.util.Constants.PARTS_SIZE

object Validator {
    fun validateDateNull(input: String) {
        require(input.trim().isNotEmpty()) {
            ErrorMessage.DATE_ERROR.getMessage()
        }
    }

    fun validateMenuNull(input: String) {
        require(input.trim().isNotEmpty()) {
            ErrorMessage.MENU_ERROR.getMessage()
        }
    }

    fun validateDate(input: Int) {
        require(input in 1..31) {
            ErrorMessage.DATE_ERROR.getMessage()
        }
    }

    fun validateInteger(input: String) {
        require(input.toIntOrNull() != null) {
            ErrorMessage.DATE_ERROR.getMessage()
        }
    }

    fun validateCounts(input: Map<String, String>) {
        input.values.forEach { countStr ->
            val count = countStr.toIntOrNull()
            require(count != null && count > 0) {
                ErrorMessage.MENU_ERROR.getMessage()
            }
        }
    }

    fun validateTotalCount(input: Collection<Int>) {
        val total = input.sum()
        require(total <= MAX_COUNT) {
            ErrorMessage.MENU_ERROR.getMessage()
        }
    }

    fun validateMenuNames(menus: Map<String, Int>) {
        menus.keys.forEach { menuName ->
            require(Menu.entries.any { it.menuName == menuName }) {
                ErrorMessage.MENU_ERROR.getMessage()
            }
        }
    }

    fun validateDuplicate(input: String, menus: Map<String, Int>) {
        val menuCount = input.split(MENU_SEPARATOR).size
        require(menuCount == menus.size) {
            ErrorMessage.MENU_ERROR.getMessage()
        }
    }

    fun validateBeverage(menus: Map<String, Int>) {
        val drinks = setOf(Menu.COKE.menuName, Menu.WINE.menuName, Menu.CHAMPAGNE.menuName)
        require(menus.keys.any { it !in drinks }) {
            ErrorMessage.MENU_ERROR.getMessage()
        }
    }

    fun validateNoBlank(input: String) {
        require(!input.contains(" ")) {
            ErrorMessage.MENU_ERROR.getMessage()
        }
    }
    fun validateMenuSeparator(input: String) {
        input.split(MENU_SEPARATOR).forEach { item ->
            require(item.contains(COUNT_SEPARATOR)) {
                ErrorMessage.MENU_ERROR.getMessage()
            }
        }
    }

    fun validateCountSeparator(input: String) {
        input.split(MENU_SEPARATOR).forEach { item ->
            val parts = item.split(COUNT_SEPARATOR)
            require(parts.size == PARTS_SIZE) {
                ErrorMessage.MENU_ERROR.getMessage()
            }
        }
    }
}