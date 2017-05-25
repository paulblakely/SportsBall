package co.joincake.cake.common

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Paul on 2/25/2017.
 */

abstract class BasePresenter<TARGET> {
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var target: TARGET? = null
        set (value) {
            if (value == null) compositeDisposable.clear()
            field = value
        }
}