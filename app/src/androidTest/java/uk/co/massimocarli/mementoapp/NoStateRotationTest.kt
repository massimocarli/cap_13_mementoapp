package uk.co.massimocarli.mementoapp


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


@RunWith(AndroidJUnit4::class)
class NoStateRotationTest {

    @get:Rule
    val activityRule = ActivityTestRule(NoStateCounterActivity::class.java)

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
}