package com.example.pamplonapark.internal_code

import android.util.Log
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.dataModels.User
import com.example.pamplonapark.interfaces.adapters.items.ParkingItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

class ServerManager {
    companion object {
        private val requests : HttpRequests = HttpRequests();

        suspend fun getAllParkings(username: String?): ArrayList<ParkingItem> {
            val result: ArrayList<ParkingItem> = ArrayList()

            val headers: LinkedHashMap<String, String> = LinkedHashMap()
            val args = JSONObject()

            headers.put("accept", "application/json")

            val token = withContext(Dispatchers.IO) {
                MainActivity.database.userDao().getTokenByUser(username + "")
            }
            args.put("auth", token)

            CoroutineScope(Dispatchers.IO).launch {

            try {
                val data = requests.post("http://34.16.20.168:3000/parkings/getAll", args, headers)
                if (data != null) {
                    val dataJSON = data

                    if (dataJSON.get("code") == 200) {
                        val info = dataJSON.optString("info")
                        val jsonArray = JSONArray(info)

                        withContext(Dispatchers.Main) {
                            // Handle the result on the main thread

                            for (i in 0 until jsonArray.length()) {
                                val parkingObject = jsonArray.getJSONObject(i)

                                result.add(
                                    ParkingItem(
                                        parkingObject.getString("address"),
                                        parkingObject.getString("hours_active"),
                                        parkingObject.getString("available_spots"),
                                        "clear"
                                    )
                                )
                            }

                            Log.d("Internal", result.toString())
                            Log.i("Internal", "Parkings retrieved correctly")
                            return@withContext result;
                        }
                    }
                }
            } catch (e: Exception) {
                Log.d("HttpRequests", e.toString())
            }
            }.join();

            return result
        }

        suspend fun registerUser(username: String, email : String, password: String): JSONObject {
            var success = JSONObject()
            success.put("status", false)

            CoroutineScope(Dispatchers.IO).launch {
                val headers: LinkedHashMap<String, String> = LinkedHashMap()
                val args = JSONObject()
                val info = JSONObject()

                info.put("email", email)
                info.put("username", username)
                info.put("password", password)

                //val (encryptedData, iv, authpath) = Crypto().encryptData(info.toString().toByteArray())

                args.put("info", info)
                //args.put("iv", iv.toString())
                //args.put("authTag", authpath.toString())

                headers.put("accept", "application/json")

                try {
                    val data = requests.post("http://34.16.20.168:3000/accounts/register", args, headers)
                    if (data != null) {
                        val dataJSON = data

                        if (dataJSON.get("code") == 200) {
                            val info = dataJSON.optString("auth")

                            CoroutineScope(Dispatchers.IO).launch {
                                MainActivity.database.userDao().insert(User(username, info))
                            }.join();

                            success.remove("status")
                            success.put("status", true)

                            Log.i("Internal", "User registered correctly")
                            //success.put("message", dataJSON.optString("message"))
                        }
                        /*else
                        {
                            success.put("message", dataJSON.optString("message"))
                        }*/
                    }
                } catch (e: Exception) {
                    Log.d("HttpRequests", e.toString())
                }
            }.join()

            return success;
        }

        suspend fun loginUser(username: String, passwordEncrypted: String): JSONObject {
            var success = JSONObject()
            success.put("status", false)

            CoroutineScope(Dispatchers.IO).launch {
                val headers: LinkedHashMap<String, String> = LinkedHashMap()
                val args = JSONObject()
                val info = JSONObject()

                info.put("username", username)
                info.put("password", passwordEncrypted)

                //val (encryptedData, iv, authpath) = Crypto().encryptData(info.toString().toByteArray())

                args.put("info", info)
                //args.put("iv", iv.toString())
                //args.put("authTag", authpath.toString())

                headers.put("accept", "application/json")

                try {
                    val data = requests.post("http://34.16.20.168:3000/accounts/login", args, headers)
                    if (data != null) {
                        val dataJSON = data

                        if (dataJSON.get("code") == 200) {
                            val info = dataJSON.optString("auth")

                            CoroutineScope(Dispatchers.IO).launch {
                                MainActivity.database.userDao().update(User(username, info))
                            }.join();

                            success.remove("status")
                            success.put("status", true)

                            Log.i("Internal", "User logged correctly")
                            //success.put("message", dataJSON.optString("message"))
                        }
                        /*else
                        {
                            success.put("message", dataJSON.optString("message"))
                        }*/
                    }
                } catch (e: Exception) {
                    Log.d("HttpRequests", e.toString())
                }
            }.join()
            return success;
        }

        suspend fun getFavorites(username: String?): List<ParkingItem> {
            val result: ArrayList<ParkingItem> = ArrayList()

            val headers: LinkedHashMap<String, String> = LinkedHashMap()
            val args = JSONObject()

            headers.put("accept", "application/json")

            val token = withContext(Dispatchers.IO) {
                MainActivity.database.userDao().getTokenByUser(username + "")
            }
            args.put("auth", token)

            CoroutineScope(Dispatchers.IO).launch {

                try {
                    val data = requests.post("http://34.16.20.168:3000/accounts/getUserFavorites", args, headers)
                    if (data != null) {
                        val dataJSON = data

                        if (dataJSON.get("code") == 200) {
                            val info = dataJSON.optString("info")
                            val jsonArray = JSONArray(info)

                            withContext(Dispatchers.Main) {
                                // Handle the result on the main thread

                                for (i in 0 until jsonArray.length()) {
                                    val parkingObject = jsonArray.getJSONObject(i)

                                    result.add(
                                        ParkingItem(
                                            parkingObject.getString("address"),
                                            parkingObject.getString("hours_active"),
                                            parkingObject.getString("available_spots"),
                                            "fill"
                                        )
                                    )
                                }

                                Log.d("Internal", result.toString())
                                Log.i("Internal", "Parkings favs retrieved correctly")
                                return@withContext result;
                            }
                        }
                    }
                } catch (e: Exception) {
                    Log.d("HttpRequests", e.toString())
                }
            }.join();

            return result
        }
    }
}