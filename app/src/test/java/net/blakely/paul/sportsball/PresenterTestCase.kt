package net.blakely.paul.sportsball

import net.blakely.paul.sportsball.common.BasePresenter
import org.mockito.Mockito


/**
 * Created by Paul on 2/25/2017.
 */

abstract class PresenterTestCase<P : BasePresenter<T>, T> : BaseTestCase() {

    abstract var presenter: P
    abstract var targetMock: T

    abstract val targetClazz: Class<T>

    @Throws(Exception::class)
    override fun setUp() {
        super.setUp()
        targetMock = Mockito.mock(targetClazz)
        presenter.target = targetMock
    }

}
