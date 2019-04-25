package uk.co.massimocarli.mementoapp.db

import android.content.Context
import android.content.SharedPreferences

class SPCounterDB(context: Context) : CounterDB {

    companion object {
        const val PREFS_NAME = "COUNTER_PREFS_NAME"
        const val COUNTER_KEY = "COUNTER_KEY"
    }

    val sharedPrefs: SharedPreferences

    init {
        sharedPrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    override var counter: Int
        get() = sharedPrefs.getInt(COUNTER_KEY, 0)
        set(value) {
            sharedPrefs.edit().putInt(COUNTER_KEY, value).commit()
        }
}