package net.blakely.paul.sportsball.gamescreen.target

/**
 * Created by Paul on 5/25/2017.
 */

interface GameTarget {
    fun setHighScore(score: Int)
    fun setScore(score: Int)
    fun enableClearButton(enabled: Boolean)
}