package com.kodingking.dislin.api.rest.core

import com.kodingking.dislin.Dislin
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.response.HttpResponse

abstract class AbstractRestAPI(protected @Transient val dislin: Dislin) {

    companion object {
        protected val httpClient = HttpClient()
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
    ) = httpClient.post<HttpResponse>(url, body = content) {
        headers.forEach { header(it.key, it.value) }
        baseApply()
        apply()
    }.asResponse<T>(dislin)

}