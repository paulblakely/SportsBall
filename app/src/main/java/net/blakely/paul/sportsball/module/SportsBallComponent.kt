package net.blakely.paul.sportsball.module

import dagger.Component
import net.blakely.paul.sportsball.gamescreen.GameActivity
import javax.inject.Singleton

/**
 * Created by Paul on 5/25/2017.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface SportsBallComponent {
    fun inject(gameActivity: GameActivity)
}