package christmas.util

enum class ErrorMessage(private val message: String) {
    MENU_NAME("는 존재하지 않는 메뉴입니다."),
    MENU_COUNT("총 메뉴의 개수는 20개를 초과할 수 없습니다."),
    MENU_NUMBER("메뉴 개수의 입력은 숫자여야 합니다."),
    MENU_DUPLICATE("메뉴는 중복될 수 없습니다."),
    MENU_FORMAT("입력의 형식이 올바르지 않습니다."),
    MENU_BEVERAGE("음료수만 주문할 수 없습니다."),
    DATE_RANGE("날짜는 1부터 31까지 입력할 수 있습니다."),
    INPUT_NUMBER("입력은 숫자여야 합니다."),
    INPUT_NULL("값이 존재하지 않습니다.");

    fun getMessage(): String = "[ERROR] $message"
}