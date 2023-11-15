package christmas.model

import christmas.util.Constants.SANTA_BADGE
import christmas.util.Constants.SANTA_BOUNDARY
import christmas.util.Constants.STAR_BADGE
import christmas.util.Constants.STAR_BOUNDARY
import christmas.util.Constants.TREE_BADGE
import christmas.util.Constants.TREE_BOUNDARY

class Badge(private val discount: Int) {
    private val _badge: String

    val badge: String
        get() = _badge

    init {
        _badge = makeBadge()
    }

    private fun makeBadge(): String {
        return when {
            discount >= SANTA_BOUNDARY -> SANTA_BADGE
            discount >= TREE_BOUNDARY -> TREE_BADGE
            discount >= STAR_BOUNDARY -> STAR_BADGE
            else -> ""
        }
    }
}