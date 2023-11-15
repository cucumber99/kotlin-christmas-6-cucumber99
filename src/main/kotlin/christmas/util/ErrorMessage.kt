package christmas.util

enum class ErrorMessage(private val message: String) {
    MENU_ERROR("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DATE_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    fun getMessage(): String = "[ERROR] $message"
}