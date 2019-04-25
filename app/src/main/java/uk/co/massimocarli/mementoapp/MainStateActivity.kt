package uk.co.massimocarli.mementoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainStateActivity : AppCompatActivity() {

    companion object {
        const val COUNTER_KEY = "COUNTER_KEY"
    }

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        incrementButton.setOnClickListener {
            count++
            displayCount()
        }
        // This could be here
        count = savedInstanceState?.getInt(COUNTER_KEY) ?: 0
        displayCount()
    }

    private fun displayCount() {
        outputLabel.text = getString(R.string.output_format, count)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(COUNTER_KEY, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState?.getInt(COUNTER_KEY) ?: 0
        displayCount()
    }
}
