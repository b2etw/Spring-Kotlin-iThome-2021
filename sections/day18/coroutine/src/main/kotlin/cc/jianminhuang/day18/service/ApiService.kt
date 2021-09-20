package cc.jianminhuang.day18.service

interface ApiService {

    suspend fun decodeBase64(encodedStr: String): String

    suspend fun decodeBase64(encodedStrs: List<String>): List<String>
}