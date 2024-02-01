package com.example.pamplonapark.internal_code

import android.os.Build
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI

class Auth
{
    fun sendGet(username: String, password: String)
    {

        val values = mapOf("username" to username, "password" to password);

        val objectMapper = ObjectMapper()
        val requestBody: String = objectMapper
            .writeValueAsString(values)

        /*val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/post"))
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString());*/
    }
}