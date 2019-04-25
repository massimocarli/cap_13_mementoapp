package uk.co.massimocarli.mementoapp.db

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * This is the LifecycleObserver for managing the counter
 */
class DBService(val db: CounterDB) : LifecycleObserver, CounterDB {
    override var counter: Int
        get() = db.counter
        set(value) {
            db.counter = value
        }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        counter = db.counter
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        db.counter = counter
    }
}