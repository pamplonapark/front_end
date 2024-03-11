package com.example.pamplonapark.internal_code

import android.util.Log
import khttp.responses.Response
import org.json.JSONObject
import kotlinx.coroutines.*

class HttpRequests() {
    /**
     * Performs a POST request to the specified URL.
     *
     * @param url The URL to perform the request.
     * @param args Arguments to append to the request.
     * @param headers Headers of the request (e.g., authentication, accepted data).
     * @return The response as a JSONObject, or null if the request fails.
     */
    fun post(url: String, args: Map<String, String>, headers: Map<String, String?>): String? {
        val args_parsed = JSONObject(args)
        val response: Response = khttp.post(url = url, headers = headers, json = args_parsed);

        if (response.statusCode == 200) {
            Log.d(
                "HttpRequests",
                "Petition accepted:\nCode:${response.statusCode}\nPetition info: ${response.request}\nResponse info: ${response.jsonObject.toString()}"
            )
            return response.text;
        } else Log.d(
            "HttpRequests", "Petition denied:\n" +
                    "Code:${response.statusCode}\n" +
                    "Petition info: ${response.request.toString()}\n" +
                    "Response info: ${response.jsonObject.toString()}"
        )

        return null;
    }
}
