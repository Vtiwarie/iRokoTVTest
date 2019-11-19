package com.example.irokutest.ui.base

import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.realm.Realm

/**
 * @author Vishaan Tiwarie
 *
 * Base Presenter class for creating MVP presenters and defining
 * all of their root functionality
 */
abstract class BasePresenter<T : BaseView> : ViewModel(), LifecycleObserver {
    protected var view: T? = null
    protected val disposables = mutableListOf<Disposable>()

    /**
     * Attach the view so we can push ("present") data to it,
     * and observe its lifecycle events
     */
    internal fun attachView(view: T, lifecycle: Lifecycle) {
        this.view = view
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun create() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun start() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun resume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun pause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun stop() {
        Realm.getDefaultInstance().close()
    }

    /**
     * Destroy the view when we are finished with it, as well
     * as Rx Disposables, both to prevent memory leaks.
     */
    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun destroy() {
        this.disposables.forEach {
            if (it.isDisposed.not()) {
                it.dispose()
            }
        }

        this.view = null
    }
}