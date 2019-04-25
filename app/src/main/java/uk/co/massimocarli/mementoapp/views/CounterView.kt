package uk.co.massimocarli.mementoapp.views

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.TextView
import uk.co.massimocarli.mementoapp.R

/**
 * Example of a custom view which has a counter as state
 */
class CounterView : TextView {

    /**
     * This is the extended state for the TextView
     */
    var counter = 0

    init {
        updateText()
    }

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun setText(text: CharSequence?, type: BufferType?) {}

    fun increment() {
        counter++
        updateText()
    }

    fun updateText() {
        super.setText(context.getString(R.string.output_format, counter), BufferType.NORMAL)
    }

    override fun onSaveInstanceState(): Parcelable? {
        val superState = super.onSaveInstanceState()
        val state = CounterMemento(superState)
        state.counterState = counter
        return state
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        super.onRestoreInstanceState(state)
        if (state is CounterMemento) {
            this.counter = state.counterState
        }
        updateText()
    }

    class CounterMemento : BaseSavedState {
        var counterState: Int = 0

        constructor(superState: Parcelable) : super(superState)

        private constructor(parcel: Parcel) : super(parcel) {
            counterState = parcel.readInt()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            super.writeToParcel(parcel, flags)
            parcel.writeInt(counterState)
        }

        override fun describeContents(): Int = 0

        companion object CREATOR : Parcelable.Creator<CounterMemento> {
            override fun createFromParcel(parcel: Parcel): CounterMemento {
                return CounterMemento(parcel)
            }

            override fun newArray(size: Int): Array<CounterMemento?> {
                return arrayOfNulls(size)
            }
        }
    }
}