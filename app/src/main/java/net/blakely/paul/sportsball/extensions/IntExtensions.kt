package net.blakely.paul.sportsball.extensions

import java.text.NumberFormat

/**
 * Created by Paul on 5/25/2017.
 */

fun Int.toFormattedString(): String {
    return NumberFormat.getInstance().format(this)
}