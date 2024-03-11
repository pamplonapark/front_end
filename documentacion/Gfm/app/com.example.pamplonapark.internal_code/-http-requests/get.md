//[app](../../../index.md)/[com.example.pamplonapark.internal_code](../index.md)/[HttpRequests](index.md)/[get](get.md)

# get

[androidJvm]\
fun [get](get.md)(url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), args: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, headers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?&gt;): [JSONObject](https://developer.android.com/reference/kotlin/org/json/JSONObject.html)?

Performs a GET request to the specified URL.

#### Return

The response as a JSONObject, or null if the request fails.

#### Parameters

androidJvm

| | |
|---|---|
| url | The URL to perform the request. |
| args | Arguments to append to the request. |
| headers | Headers of the request (e.g., authentication, accepted data). |
