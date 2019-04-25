package uk.co.massimocarli.mementoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        incrementButton.setOnClickListener {
            count++
            displayCount()
        }
        displayCount()
    }

    private fun displayCount() {
        outputLabel.text = getString(R.string.output_format, count)
    }
}
