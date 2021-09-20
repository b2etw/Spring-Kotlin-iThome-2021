package cc.jianminhuang.day18.web.controller

import cc.jianminhuang.day18.service.ApiService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/base64")
class TestController(
    val apiService: ApiService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/{encodedStr}")
    suspend fun get(@PathVariable encodedStr: String) =
        also {
            logger.info(encodedStr)
        }.run {
            apiService.decodeBase64(encodedStr)
        }

    @PostMapping
    suspend fun decodeBase64Strs(@RequestBody base64Strs: List<String>) =
        also {
            logger.info(base64Strs.toString())
        }.run {
            apiService.decodeBase64(base64Strs)
        }
}