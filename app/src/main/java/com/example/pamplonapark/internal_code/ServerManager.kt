package com.example.pamplonapark.internal_code

import android.util.Log
import com.example.pamplonapark.interfaces.adapters.items.ParkingItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray

class ServerManager {
    companion object {
        val requests : HttpRequests = HttpRequests();
        fun importDataFromNeo4j(): List<ParkingItem> {
            val result: ArrayList<ParkingItem> = ArrayList();

            CoroutineScope(Dispatchers.Main).launch {
                val headers: LinkedHashMap<String, String> = LinkedHashMap();
                val args: LinkedHashMap<String, String> = LinkedHashMap();
                val result: ArrayList<ParkingItem> = ArrayList();

                headers.put("accept", "application/json");
                headers.put("Authorization", "1234");

                try {
                    val data = requests.get("http://192.168.56.1:3000/parkings/v1/getAllParkings", args, headers)
                    Log.d("test", data.toString());
                    if (data != null) {
                        val jsonArray = JSONArray(data);

                        // Iterate over each node JSON object
                        for (i in 0 until jsonArray.length()) {
                            val nodeObject = jsonArray.getJSONObject(i)

                            // Extract information from the node JSON object
                            val fieldsArray = nodeObject.getJSONArray("_fields")
                            val fieldsObject = fieldsArray.getJSONObject(0)
                            val propertiesObject = fieldsObject.getJSONObject("properties")

                            // Extract specific properties from the propertiesObject
                            val name = propertiesObject.getString("name")
                            val address = propertiesObject.getString("address")
                            val availableSpots = propertiesObject.getString("available_spots")

                            Log.d("test", name)
                        }
                        /*for(i in 0 until dataParsed.length()) {
                                val id = dataParsed.getJSONObject(i).getJSONArray("_fields")[0];
                                val name = dataParsed.getJSONObject(i).getJSONArray("_fields")[0];

                            Log.d("test-info", id.toString())
                            Log.d("test-info", name.toString())
                                //result.add(ParkingItem(id, name));
                        }*/
                    }

                } catch (e: Exception) {
                    Log.d("test", e.toString());
                }
            }

            return result;
        }
    }
}