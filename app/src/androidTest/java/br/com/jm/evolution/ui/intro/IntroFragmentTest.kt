package br.com.jm.evolution.ui.intro

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.jm.evolution.R
import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IntroFragmentTest: TestCase() {
    private lateinit var scenario: FragmentScenario<IntroFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_Evolution)
        scenario.moveToState(newState = Lifecycle.State.STARTED)
    }

    @Test
    fun shouldTitleWelcomeIsCorrectlyAndVisible() {
        onView(withId(R.id.welcome_title))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
            .check(matches(withText(R.string.welcome_title)))
    }

    @Test
    fun shouldSubTitleWelcomeIsCorrectlyAndVisible() {
        onView(withId(R.id.welcome_subtitle))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
            .check(matches(withText(R.string.welcome_subtitle)))
    }
}