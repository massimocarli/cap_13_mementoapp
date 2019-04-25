package uk.co.massimocarli.mementoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.massimocarli.mementoapp.db.DBService
import uk.co.massimocarli.mementoapp.db.SPCounterDB

class PersistenceCounterActivity : AppCompatActivity() {

    lateinit var dbService: DBService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbService = DBService(SPCounterDB(this))
        lifecycle.addObserver(dbService)
        setContentView(R.layout.activity_main)
        incrementButton.setOnClickListener {
            dbService.counter++
            displayCount()
        }
        displayCount()
    }

    private fun displayCount() {
        outputLabel.text = getString(R.string.output_format, dbService.counter)
    }
}
