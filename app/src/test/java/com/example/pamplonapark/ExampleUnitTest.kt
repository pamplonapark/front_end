package com.example.pamplonapark

import com.example.pamplonapark.internal_code.Crypto
import com.example.pamplonapark.internal_code.ServerManager
import com.google.common.truth.Truth.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun registerUser()
    {
        val registrationResult = runBlocking {
            ServerManager.registerUser("1234", "1234", Crypto().encryptPassword("1234"))
        }
        assertThat(registrationResult.get("status")).isEqualTo(false) // Usuario ya existe
    }

    @Test
    fun loginUser()
    {
        val registrationResult = runBlocking {
            ServerManager.registerUser("1234", "1234", Crypto().encryptPassword("1234"))
        }
        assertThat(registrationResult.get("status")).isEqualTo(true) // Usuario ya existe
    }
}