package cc.jianminhuang.day13.mq

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class MessageProducer(
    val rabbitTemplate: RabbitTemplate
) {

//    @Scheduled(cron = "*/5 * * * * *")
//    fun sendMsg() = rabbitTemplate.convertAndSend("simple", "${java.lang.System.currentTimeMillis()}")

    @Scheduled(cron = "*/5 * * * * *")
    fun sendBroadCast() = rabbitTemplate.convertAndSend("test", "simple", "${System.currentTimeMillis()}")
}