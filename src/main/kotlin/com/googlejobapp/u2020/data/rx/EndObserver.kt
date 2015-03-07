package com.googlejobapp.u2020.data.rx

import rx.Observer

/**
 * Created by joeyt on 3/7/15.
 */
abstract class EndObserver<T> : Observer<T> {
    override fun onCompleted() { onEnd() }

    override fun onError(e: Throwable?) { onEnd() }

    abstract fun onEnd()
}