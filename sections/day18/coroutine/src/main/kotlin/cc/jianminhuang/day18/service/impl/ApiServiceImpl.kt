package cc.jianminhuang.day18.service.impl

import cc.jianminhuang.day18.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class ApiServiceImpl : ApiService {

    private val webClient = WebClient.builder().build()

    override suspend fun decodeBase64(encodedStr: String) = doBase64Decode(encodedStr)

    override suspend fun decodeBase64(encodedStrs: List<String>) =
        coroutineScope {
            encodedStrs.map { async(Dispatchers.IO) { doBase64Decode(it) } }.toList().awaitAll()
        }

    private suspend fun doBase64Decode(encodedStr: String) = webClient.get()
        .uri("https://httpbin.org/base64/$encodedStr")
        .retrieve()
        .awaitBody<String>()
}