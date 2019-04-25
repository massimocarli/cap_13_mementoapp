package uk.co.massimocarli.mementoapp.views

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import uk.co.massimocarli.mementoapp.R

/**
 * Example of a custom view which has a counter as state
 */
class NoStateCounterView : TextView {

    /**
     * This is the extended state for the TextView
     */
    var counter = 0

    init {
        updateText()
    }

    constructor(context: Context?) : super(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs, 0)

    override fun setText(text: CharSequence?, type: BufferType?) {}

    fun increment() {
        counter++
        updateText()
    }

    fun updateText() {
        super.setText(context.getString(R.string.output_format, counter), BufferType.NORMAL)
    }
}