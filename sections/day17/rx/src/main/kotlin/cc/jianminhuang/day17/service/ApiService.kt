package cc.jianminhuang.day17.service

import reactor.core.publisher.Mono

interface ApiService {

    fun decodeBase64(encodedStr: String): Mono<String>

    fun decodeBase64(encodedStrs: List<String>): Mono<MutableList<String>>
}