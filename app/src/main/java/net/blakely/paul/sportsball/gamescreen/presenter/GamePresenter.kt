package net.blakely.paul.sportsball.gamescreen.presenter

import net.blakely.paul.sportsball.common.BasePresenter
import net.blakely.paul.sportsball.gamescreen.target.GameTarget
import net.blakely.paul.sportsball.preferences.PreferencesManager
import javax.inject.Inject

/**
 * Created by Paul on 5/25/2017.
 */

class GamePresenter @Inject constructor(val preferencesManager: PreferencesManager) : BasePresenter<GameTarget>() {

    var highScore = 0
    var currentScore = 0

    fun setup() {
        highScore = preferencesManager.highScore
        target?.setHighScore(highScore)
    }

    fun handleAddPointsButtonClicked() {
        currentScore += 100
        target?.setScore(currentScore)
        if (currentScore > highScore) {
            highScore = currentScore
            preferencesManager.highScore = currentScore
            target?.setHighScore(currentScore)
        }
    }

    fun handleConfirmCheckboxChecked(checked: Boolean) {
        target?.enableClearButton(checked)
    }

    fun handleClearButtonPressed() {
        currentScore = 0
        target?.setScore(0)
    }
}