package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.Validator.validateCountSeparator
import christmas.util.Validator.validateDateNull
import christmas.util.Validator.validateInteger
import christmas.util.Validator.validateMenuNull
import christmas.util.Validator.validateMenuSeparator
import christmas.util.Validator.validateNoBlank

class InputView {
    private fun getUserInput(): String = Console.readLine()

    fun getDate(): Int {
        val input = getUserInput()
        validateDateNull(input)
        validateInteger(input)
        return input.toInt()
    }

    fun getMenu(): String {
        val input = getUserInput()
        validateMenuNull(input)
        validateNoBlank(input)
        validateMenuSeparator(input)
        validateCountSeparator(input)
        return input
    }
}