//[app](../../../index.md)/[com.example.pamplonapark.internal_code](../index.md)/[HttpRequests](index.md)

# HttpRequests

[androidJvm]\
class [HttpRequests](index.md)

Utility class for making HTTP requests. This class provides methods for performing POST and GET requests to a server.

## Constructors

| | |
|---|---|
| [HttpRequests](-http-requests.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [androidJvm]<br>fun [get](get.md)(url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), args: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, headers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?&gt;): [JSONObject](https://developer.android.com/reference/kotlin/org/json/JSONObject.html)?<br>Performs a GET request to the specified URL. |
| [post](post.md) | [androidJvm]<br>fun [post](post.md)(url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), args: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, headers: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?&gt;): [JSONObject](https://developer.android.com/reference/kotlin/org/json/JSONObject.html)?<br>Performs a POST request to the specified URL. |
