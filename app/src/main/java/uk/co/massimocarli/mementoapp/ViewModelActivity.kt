package uk.co.massimocarli.mementoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.massimocarli.mementoapp.viewmodel.CounterViewModel

class ViewModelActivity : AppCompatActivity() {

    lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        incrementButton.setOnClickListener {
            counterViewModel.counter++
            displayCount()
        }
        displayCount()
    }

    private fun displayCount() {
        outputLabel.text = getString(R.string.output_format, counterViewModel.counter)
    }
}
