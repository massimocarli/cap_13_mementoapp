package uk.co.massimocarli.mementoapp


import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import uk.co.massimocarli.mementoapp.db.SPCounterDB


@RunWith(AndroidJUnit4::class)
class ViewModelActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(ViewModelActivity::class.java)

    @Test
    fun testStateAfterRotation() {
        // We click 5 time on the button
        (1..5).forEach {
            onView(withId(R.id.incrementButton))
                .perform(click())
        }
        // We rotate
        rotateScreen()
        // We check the content of the output label
        onView(withId(R.id.outputLabel))
            .check(matches(withText("Count 5")))
    }

    private fun rotateScreen() {
        val context = InstrumentationRegistry.getInstrumentation().context
        val orientation = context.getResources().getConfiguration().orientation

        val activity = activityRule.activity
        activity.requestedOrientation = if (orientation == Configuration.ORIENTATION_PORTRAIT)
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        else
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    // Clears all the shared prefs
    private fun clearSharedPrefs() {
        InstrumentationRegistry.getInstrumentation().context.getSharedPreferences(
            SPCounterDB.PREFS_NAME,
            Context.MODE_PRIVATE
        ).edit().putInt(SPCounterDB.COUNTER_KEY, 0).commit()
    }
}