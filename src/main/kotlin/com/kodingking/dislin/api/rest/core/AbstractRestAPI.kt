package com.kodingking.dislin.api.rest.core

import com.kodingking.dislin.Dislin
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.client.response.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

abstract class AbstractRestAPI(@Transient protected val dislin: Dislin) {

    companion object {
        protected val httpClient = HttpClient {
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
        }
    }

    protected open val baseApply: HttpRequestBuilder.() -> Unit = {}

    protected suspend inline fun <reified T> httpGet(
        url: String,
        headers: HashMap<String, String> = hashMapOf(),
        apply: HttpRequestBuilder.() -> Unit = {}
    ) = httpClient.get<HttpResponse>(url) {
        headers.forEach { header(it.key, it.value) }
        baseApply()
        apply()
    }.asResponse<T>(dislin)

    protected suspend inline fun <reified T> httpPost(
        url: String,
        headers: HashMap<String, String> = hashMapOf(),
        content: Any = "{}",
        apply: HttpRequestBuilder.() -> Unit = {}
    ) = httpClient.post<HttpResponse>(url) {
        body = content
        contentType(ContentType.parse("application/json"))
        headers.forEach { header(it.key, it.value) }
        baseApply()
        apply()
    }.asResponse<T>(dislin)

    protected suspend inline fun <reified T> httpDelete(
        url: String,
        headers: HashMap<String, String> = hashMapOf(),
        apply: HttpRequestBuilder.() -> Unit = {}
    ) = httpClient.delete<HttpResponse>(url) {
        headers.forEach { header(it.key, it.value) }
        baseApply()
        apply()
    }.asResponse<T>(dislin)

}