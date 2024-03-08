package com.example.pamplonapark.internal_code

import android.util.Log
import khttp.responses.Response
import org.json.JSONObject

/**
 * Utility class for making HTTP requests.
 * This class provides methods for performing POST and GET requests to a server.
 */
class HttpRequests {

    /**
     * Performs a POST request to the specified URL.
     *
     * @param url The URL to perform the request.
     * @param args Arguments to append to the request.
     * @param headers Headers of the request (e.g., authentication, accepted data).
     * @return The response as a JSONObject, or null if the request fails.
     */
    fun post(url: String, args: Map<String, String>, headers: Map<String, String?>): JSONObject? {
        val response: Response = khttp.post(url = url, headers = headers, json = args)

        if (response.statusCode == 200) {
            Log.i(
                "HttpRequests",
                "Request accepted:\nCode: ${response.statusCode}\nRequest info: ${response.request}\nResponse info: $response"
            )
            return response.jsonObject
        } else {
            Log.e(
                "HttpRequests",
                "Request denied:\nCode: ${response.statusCode}\nRequest info: ${response.request}\nResponse info: $response"
            )
        }
        return null
    }

    /**
     * Performs a GET request to the specified URL.
     *
     * @param url The URL to perform the request.
     * @param args Arguments to append to the request.
     * @param headers Headers of the request (e.g., authentication, accepted data).
     * @return The response as a JSONObject, or null if the request fails.
     */
    fun get(url: String, args: Map<String, String>, headers: Map<String, String?>): JSONObject? {
        val response: Response = khttp.get(url = url, headers = headers, data = args)

        if (response.statusCode == 200) {
            Log.i(
                "HttpRequests",
                "Request accepted:\nCode: ${response.statusCode}\nRequest info: ${response.request}\nResponse info: $response"
            )
            return response.jsonObject
        } else {
            Log.e(
                "HttpRequests",
                "Request denied:\nCode: ${response.statusCode}\nRequest info: ${response.request}\nResponse info: $response"
            )
        }
        return null
    }
}
