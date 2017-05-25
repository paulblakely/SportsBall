package net.blakely.paul.sportsball.gamescreen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game.*
import net.blakely.paul.sportsball.R
import net.blakely.paul.sportsball.SportsBall
import net.blakely.paul.sportsball.extensions.toFormattedString
import net.blakely.paul.sportsball.gamescreen.presenter.GamePresenter
import net.blakely.paul.sportsball.gamescreen.target.GameTarget
import javax.inject.Inject


class GameActivity : AppCompatActivity(), GameTarget {

    @Inject lateinit var presenter: GamePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        (application as SportsBall).sportsBallComponent.inject(this)
        addPointsButton.setOnClickListener { presenter.handleAddPointsButtonClicked() }
        clearPointsButton.setOnClickListener { presenter.handleClearButtonPressed() }
        clearPointsCheckbox.setOnCheckedChangeListener { _, isChecked -> presenter.handleConfirmCheckboxChecked(isChecked) }
    }

    override fun onStart() {
        super.onStart()
        presenter.target = this
        presenter.setup()
    }

    override fun onStop() {
        super.onStop()
        presenter.target = null
    }

    override fun setHighScore(score: Int) {
        highScoreText.text = score.toFormattedString()
    }

    override fun setScore(score: Int) {
        currentScoreText.text = score.toFormattedString()
    }

    override fun enableClearButton(enabled: Boolean) {
        clearPointsButton.isEnabled = enabled
    }
}
