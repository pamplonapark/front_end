package com.example.pamplonapark.internal_code

import android.util.Log
import com.example.pamplonapark.interfaces.adapters.items.ParkingItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import org.json.JSONObject

class ServerManager {
    companion object {
        private val crypto : Crypto = Crypto()
        private val requests : HttpRequests = HttpRequests();

        fun getAllParkings() = runBlocking {
            val result: ArrayList<ParkingItem> = ArrayList();

            CoroutineScope(Dispatchers.IO).launch {
                val headers: LinkedHashMap<String, String> = LinkedHashMap();
                val args: LinkedHashMap<String, String> = LinkedHashMap();
                val result: ArrayList<ParkingItem> = ArrayList();

                headers.put("accept", "application/json");
                args.put("auth", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1dWlkIjoiMDIxNjg1ZTgtZDg0OC0xMWVlLTkyODItZDg1ZWQzNWIxZThkIiwidXNlcm5hbWUiOiJ2ZXJhIiwiaWF0IjoxNzA5MzY2MzE4LCJleHAiOjI0NjY3NDg3MTh9.SG49TM3W5TskBLMmc9G3dHpRQKMUu-3-1TgNCzovSi8");

                try {
                    val data = requests.post("http://192.168.56.1:5000/parkings/getAll", args, headers)
                    if (data != null) {
                        var dataJSON = JSONObject(data);

                        if(dataJSON.get("code") == 200) {
                            val info = dataJSON.optString("info")
                            val jsonArray = JSONArray(info)

                            for (i in 0 until jsonArray.length()) {
                                val parkingObject = jsonArray.getJSONObject(i)
                                result.add(ParkingItem(parkingObject.getString("uuid"), parkingObject.getString("name")));
                            }
                            Log.i("Internal", "Parkings retrieved correctly");
                        }
                        else return@launch;
                    }
                } catch (e: Exception) {
                    Log.d("HttpRequests", e.toString());
                }
            }

            return@runBlocking result;
        }

        fun registerUser(username: String, email : String, password: String)
        {
            //val password : String = crypto.parseToString(crypto.encryptPassword(password));
        }
    }
}