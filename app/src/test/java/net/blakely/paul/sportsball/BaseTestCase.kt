package net.blakely.paul.sportsball

import android.support.annotation.CallSuper
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.mockito.MockitoAnnotations

/**
 * Created by Paul on 2/25/2017.
 */

abstract class BaseTestCase {

    @CallSuper
    @Before
    open fun setUp() {
        MockitoAnnotations.initMocks(this)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() } //Run all AndroidSchedulers.mainThread() stuff in JVM
    }
}