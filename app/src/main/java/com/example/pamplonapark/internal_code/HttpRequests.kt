package com.example.pamplonapark.internal_code

import android.util.Log
import khttp.responses.Response
import org.json.JSONObject
import kotlinx.coroutines.*

<<<<<<< HEAD
class HttpRequests()
{
=======
/**
 * Utility class for making HTTP requests.
 * This class provides methods for performing POST and GET requests to a server.
 */
class HttpRequests {

>>>>>>> e3740b37ee9698d4bb3c2b03d0356eab5795dc51
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

<<<<<<< HEAD
    fun post(url : String, args : Map<String, String>, headers: Map<String, String?>) : String?
    {
        val response : Response = khttp.post(url = url, headers = headers, json = args);

        if(response.statusCode == 200)
        {
            Log.d("HttpRequests", "Petition accepted:\nCode:${response.statusCode}\nPetition info: ${response.request}\nResponse info: ${response.jsonObject.toString()}")
            return response.text;
        } else Log.d("HttpRequests", "Petition denied:\n" +
                "Code:${response.statusCode}\n" +
                "Petition info: ${response.request.toString()}\n" +
                "Response info: ${response.jsonObject.toString()}")

        return null;
=======
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
>>>>>>> e3740b37ee9698d4bb3c2b03d0356eab5795dc51
    }
}
