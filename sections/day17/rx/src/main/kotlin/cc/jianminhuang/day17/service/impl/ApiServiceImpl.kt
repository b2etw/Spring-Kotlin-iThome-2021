package cc.jianminhuang.day17.service.impl

import cc.jianminhuang.day17.service.ApiService
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

@Service
class ApiServiceImpl : ApiService {

    private val webClient = WebClient.builder().build()

    override fun decodeBase64(encodedStr: String) = doBase64Decode(encodedStr)

    override fun decodeBase64(encodedStrs: List<String>) =
        run {
            encodedStrs.map { doBase64Decode(it) }.toList()
        }.run {
            Flux.mergeSequential(this)
                .publishOn(Schedulers.parallel())
                .collectList()
        }

    private fun doBase64Decode(encodedStr: String) = webClient.get()
        .uri("https://httpbin.org/base64/$encodedStr")
        .retrieve()
        .bodyToMono(String::class.java)
}