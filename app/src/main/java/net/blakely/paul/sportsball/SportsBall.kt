package net.blakely.paul.sportsball

import android.app.Application
import net.blakely.paul.sportsball.module.AppModule
import net.blakely.paul.sportsball.module.DaggerSportsBallComponent
import net.blakely.paul.sportsball.module.SportsBallComponent

/**
 * Created by Paul on 5/25/2017.
 */

class SportsBall : Application() {
    val sportsBallComponent: SportsBallComponent by lazy {
        DaggerSportsBallComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}