package com.example.pamplonapark.internal_code

import android.util.Log
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.dataModels.User
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

        suspend fun getAllParkings(): ArrayList<ParkingItem> {
            val result: ArrayList<ParkingItem> = ArrayList()

            val headers: LinkedHashMap<String, String> = LinkedHashMap()
            val args: LinkedHashMap<String, String> = LinkedHashMap()

            headers.put("accept", "application/json")
            args.put("auth", "YourAuthTokenHere")

            try {
                val data = requests.post("http://34.16.20.168:3000/parkings/getAll", args, headers)
                if (data != null) {
                    val dataJSON = JSONObject(data)

                    if (dataJSON.get("code") == 200) {
                        val info = dataJSON.optString("info")
                        val jsonArray = JSONArray(info)

                        for (i in 0 until jsonArray.length()) {
                            val parkingObject = jsonArray.getJSONObject(i)
                            result.add(ParkingItem(parkingObject.getString("address"), parkingObject.getString("name"), parkingObject.getString(""), ""))
                        }
                        Log.i("Internal", "Parkings retrieved correctly")
                    }
                }
            } catch (e: Exception) {
                Log.d("HttpRequests", e.toString())
            }

            return result
        }

        suspend fun registerUser(username: String, email : String, password: String): Boolean {
            var success = false

            CoroutineScope(Dispatchers.IO).launch {
                val headers: LinkedHashMap<String, String> = LinkedHashMap()
                val args = LinkedHashMap<String, String>()
                val info = LinkedHashMap<String, String>()

                info.put("email", email)
                info.put("username", username)
                info.put("password", password)

                //val (encryptedData, iv, authpath) = Crypto().encryptData(info.toString().toByteArray())

                args.put("info", info.toString())
                //args.put("iv", iv.toString())
                //args.put("authTag", authpath.toString())

                headers.put("accept", "application/json")

                try {
                    val data = requests.post("http://192.168.56.1:5000/accounts/register", args, headers)
                    if (data != null) {
                        val dataJSON = JSONObject(data)

                        if (dataJSON.get("code") == 200) {
                            val info = dataJSON.optString("auth")

                            MainActivity.database.userDao().insert(User(username, info))
                            success = true

                            Log.i("Internal", "User registered correctly")
                        }
                    }
                } catch (e: Exception) {
                    Log.d("HttpRequests", e.toString())
                }
            }.join()

            return success;
        }

        fun loginUser(username: String, passwordEncrypted: String): Boolean {
            var success = false
            CoroutineScope(Dispatchers.IO).launch {
                val headers: LinkedHashMap<String, String> = LinkedHashMap()
                val args = LinkedHashMap<String, String>()
                val info = LinkedHashMap<String, String>()

                info.put("username", username)
                info.put("password", passwordEncrypted)

                //val (encryptedData, iv, authpath) = Crypto().encryptData(info.toString().toByteArray())

                args.put("info", info.toString())
                //args.put("iv", iv.toString())
                //args.put("authTag", authpath.toString())

                headers.put("accept", "application/json")

                try {
                    val data = requests.post("http://34.16.20.168:3000/accounts/login", args, headers)
                    if (data != null) {
                        val dataJSON = JSONObject(data)

                        if (dataJSON.get("code") == 200) {
                            val info = dataJSON.optString("auth")

                            MainActivity.database.userDao().insert(User(username, info))
                            success = true
                            Log.i("Internal", "User logged correctly")
                        }
                    }
                } catch (e: Exception) {
                    Log.d("HttpRequests", e.toString())
                }
            }
            return success;
        }
    }
}