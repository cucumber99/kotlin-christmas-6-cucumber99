package christmas.model

enum class Menu(val menuName: String, val price: Int) {
    SOUP("수프", 6_000),
    TAPAS("타파스", 5_500),
    SALAD("시저샐러드", 8_000),
    STEAK("티본스테이크", 55_000),
    RIB("바비큐립", 54_000),
    SEAFOOD("해산물파스타", 35_000),
    CHRISTMAS("크리스마스파스타", 25_000),
    CAKE("초코케이크", 15_000),
    ICE("아이스크림", 5_000),
    COKE("제로콜라", 3_000),
    WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);
}