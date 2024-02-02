package com.example.pamplonapark.internal_code

import android.util.Log
import khttp.responses.Response
import org.json.JSONObject

class HttpRequests
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

    fun post(url : String, args : Map<String, String>, headers: Map<String, String?>) : JSONObject?
    {
        val response : Response = khttp.post(url = url, headers = headers, json = args);

        if(response.statusCode == 200)
        {
            Log.i("HttpRequests", "Petition accepted:\nCode:${response.statusCode}\nPetition info: ${response.request}\nResponse info: $response")
            return response.jsonObject;
        } else Log.e("HttpRequests", "Petition denied:\n" +
                "Code:${response.statusCode}\n" +
                "Petition info: ${response.request}\n" +
                "Response info: $response")

        return null;
    }

    /**
     * Create a GET method to server
     *
     * @param url : URL to perform the request : String
     * @param args : Arguments (data to append to request) : Map<String, String>
     * @param headers : Headers of the request (auth, accepted data...) : Map<String, String?>
     *
     * @return JSONObject or NULL (if request fails)
     * */
    fun get(url : String, args : Map<String, String>, headers: Map<String, String?>) : JSONObject?
    {
        val response : Response = khttp.get(url = url, headers = headers, data = args);

        if(response.statusCode == 200)
        {
            Log.i("HttpRequests", "Petition accepted:\nCode:${response.statusCode}\nPetition info: ${response.request}\nResponse info: $response")
            return response.jsonObject;
        } else Log.e("HttpRequests", "Petition denied:\n" +
                "Code:${response.statusCode}\n" +
                "Petition info: ${response.request}\n" +
                "Response info: $response")

        return null;
    }
}