package com.example.pamplonapark

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test

class MainActivityTest {

    //Cargar la Actividad Main(Ventana de Bienvenida)
    @Test
    fun test_MainActivity_carga() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun testIniciarSesionButtonClick() {
        // Inicia la actividad principal
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Hace clic en el botón de iniciar sesión
        onView(withId(R.id.iniciarSesion)).perform(click())

        // Verifica que la actividad de inicio de sesión se haya iniciado
        onView(withId(R.id.login_activity_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun testRegistrarButtonClick() {
        // Inicia la actividad principal
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Hace clic en el botón de Registrar
        onView(withId(R.id.iniciarSesion)).perform(click())

        // Verifica que la actividad de Registrar se haya iniciado
        onView(withId(R.id.signup_activity_layout)).check(matches(isDisplayed()))
    }



}
