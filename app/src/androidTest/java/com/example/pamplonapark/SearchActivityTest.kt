package com.example.pamplonapark

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Assert.*
import org.junit.Test

class SearchActivityTest {

    @Test
    fun testFavoritosButtonClick() {
        // Inicia la actividad principal
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Realiza clic en el botón de favoritos
        onView(withId(R.id.favs)).perform(click())

        // Verifica que se haya lanzado la actividad FavoritoActivity
        onView(withId(R.id.favoritos_activity_layout)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
