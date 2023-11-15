package christmas.util

enum class ErrorMessage(private val message: String) {
    MENU_ERROR("유효하지 않은 주문입니다. 다시 입력해 주세요.\n"),
    DATE_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요.\n");

    fun getMessage(): String = "[ERROR] $message"
}