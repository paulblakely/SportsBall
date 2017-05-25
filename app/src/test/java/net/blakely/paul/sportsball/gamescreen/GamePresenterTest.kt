package net.blakely.paul.sportsball.gamescreen

import co.joincake.cake.PresenterTestCase
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import net.blakely.paul.sportsball.gamescreen.presenter.GamePresenter
import net.blakely.paul.sportsball.gamescreen.target.GameTarget
import net.blakely.paul.sportsball.preferences.PreferencesManager
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

/**
 * Created by Paul on 5/25/2017.
 */

class GamePresenterTest : PresenterTestCase<GamePresenter, GameTarget>() {

    override lateinit var targetMock: GameTarget
    override val targetClazz = GameTarget::class.java

    @InjectMocks override lateinit var presenter: GamePresenter
    @Mock lateinit var preferencesManager: PreferencesManager

    @Test
    fun handleAddPointsButtonClicked_shouldCallSetPoints() {
        presenter.handleAddPointsButtonClicked()

        verify(targetMock).setScore(any())
    }

    @Test
    fun setup_shouldPopulateHighScore() {
        val highscore = 6000
        whenever(preferencesManager.highScore).thenReturn(highscore)

        presenter.setup()

        verify(targetMock).setHighScore(highscore)
    }

    @Test
    fun handleConfirmCheckboxChecked_shouldEnableOrDisableClearButton() {
        presenter.handleConfirmCheckboxChecked(true)

        verify(targetMock).enableClearButton(true)
    }

}