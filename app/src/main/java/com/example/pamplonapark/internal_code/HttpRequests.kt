package com.example.pamplonapark.internal_code

import android.util.Log
import khttp.responses.Response
import org.json.JSONObject
import kotlinx.coroutines.*

class HttpRequests()
{
    /**
     * Create a POST method to server
     *
     * @param url : URL to perform the request : String
     * @param args : Arguments (data to append to request) : Map<String, String>
     * @param headers : Headers of the request (auth, accepted data...) : Map<String, String?>
     *
     * @return JSONObject or NULL (if request fails)
     * */

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
    }
}