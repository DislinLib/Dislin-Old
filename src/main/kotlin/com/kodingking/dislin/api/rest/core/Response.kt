package com.kodingking.dislin.api.rest.core

import com.kodingking.dislin.Dislin
import com.kodingking.dislin.DislinData
import io.ktor.client.response.HttpResponse
import io.ktor.http.Headers
import kotlinx.coroutines.io.jvm.javaio.toInputStream

data class Response<T>(
    val body: T,
    val statusCode: Int,
    val headers: Headers
)

inline fun <reified T> HttpResponse.asResponse(dislin: Dislin) =
    Response(
        DislinData.getGson(dislin).fromJson(content.toInputStream().bufferedReader().readText(), T::class.java),
        status.value,
        headers
    )