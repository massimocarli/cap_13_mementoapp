package uk.co.massimocarli.mementoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_no_state.*

class NoStateCounterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_state)
        incrementButton.setOnClickListener {
            outputLabel.increment()
        }
    }
}
