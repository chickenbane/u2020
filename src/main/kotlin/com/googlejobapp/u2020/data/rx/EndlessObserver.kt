package com.googlejobapp.u2020.data.rx

import rx.Observer

/**
 * Created by joeyt on 3/7/15.
 */
abstract class EndlessObserver<T> : Observer<T> {
    override fun onCompleted() {}

    override fun onError(e: Throwable?) {}
}